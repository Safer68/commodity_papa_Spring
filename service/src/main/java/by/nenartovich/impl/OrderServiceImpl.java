package by.nenartovich.impl;


import by.nenartovich.OrderService;
import by.nenartovich.dao.OrderRepository;
import by.nenartovich.dto.OrderDto;
import by.nenartovich.mappers.OrderMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDto findById(Long orderId) {
        return orderMapper.orderToOrderDto(orderRepository.getReferenceById(orderId));
    }

    @Override
    public List<OrderDto> findAllOrderDto() {
        return null;
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        if (orderDto.getId() == null) {
            orderDto.setDateCreate(new Date());
        }
        orderDto.setDateChange(new Date());
        return orderMapper.orderToOrderDto(orderRepository.save(orderMapper.orderDtoToOrder(orderDto)));
    }
    @Override
    public Page<OrderDto> findPaginated(Pageable pageable) {
        List<OrderDto> orders = orderRepository.findAll().stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toList());
        List<OrderDto> list;
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        if (orders.size() < startItem){
            list = Collections.emptyList();
        }else {
            int toIndex = Math.min(startItem+pageSize,orders.size());
            list = orders.subList(startItem,toIndex);
        }
        return new PageImpl<OrderDto>(list, PageRequest.of(currentPage,pageSize),orders.size());
    }
    @Override
    public Page<OrderDto> findAllPaginated(int pageNumber, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable paged = PageRequest.of(pageNumber - 1, 5, sort);
        return orderRepository.findAll(paged).map(orderMapper::orderToOrderDto);
    }
}
