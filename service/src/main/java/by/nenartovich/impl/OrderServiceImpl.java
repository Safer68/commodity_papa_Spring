package by.nenartovich.impl;


import by.nenartovich.OrderFilter;
import by.nenartovich.OrderService;
import by.nenartovich.Parameter;
import by.nenartovich.dao.ClientRepository;
import by.nenartovich.dao.ManagerRepository;
import by.nenartovich.dao.OrderRepository;
import by.nenartovich.dto.OrderDto;
import by.nenartovich.entity.Order;
import by.nenartovich.mappers.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ManagerRepository managerRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto findById(Long orderId) {
        return orderMapper.orderToOrderDto(orderRepository.getReferenceById(orderId));
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        Order order = orderRepository.getReferenceById(orderDto.getId());
        orderRepository.save(orderMapper.updateOrderFromOrderDto(orderDto, order));
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        if (orderDto.getId() == null) {
            orderDto.setDateCreate(new Date());
        }
        orderDto.setDateChange(new Date());
        return orderMapper.orderToOrderDto(orderRepository.save(orderMapper.orderDtoToOrder(orderDto)));
    }

    public Page<OrderDto> findAllPaginated(OrderFilter orderFilter, Parameter parameter) {
        Specification<Order> orderSpecification =
                Specification
                        .where(Optional.ofNullable(orderFilter.gDateCreateBefore())
                                .map(SpecificationOrder::getOrderByCreatDateBefore)
                                .orElse(null))
                        .and(Optional.ofNullable(orderFilter.gDateCreateFor())
                                .map(SpecificationOrder::getOrderByCreatDateFor)
                                .orElse(null))
                        .and(Optional.ofNullable(clientRepository.findByName(orderFilter.getClientName()))
                                .map(SpecificationOrder::getOrderByClientSpec)
                                .orElse(null))
                        .and(Optional.ofNullable(managerRepository.findByName(orderFilter.getManagerName()))
                                .map(SpecificationOrder::getOrderByManagerSpec)
                                .orElse(null))
                        .and(Optional.ofNullable(orderFilter.getStatusOrder())
                                .map(SpecificationOrder::getOrderStatusSpec)
                                .orElse(null));
        Sort sort = parameter.getSortDir().equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(parameter.getSortField()).ascending()
                : Sort.by(parameter.getSortField()).descending();
        Pageable paged = PageRequest.of(parameter.getPageNumber() - 1, parameter.getPageSize(), sort);
        return orderRepository.findAll(orderSpecification, paged).map(orderMapper::orderToOrderDto);
    }
}
