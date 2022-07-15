package by.nenartovich.impl;


import by.nenartovich.ManagerService;
import by.nenartovich.OrderFilter;
import by.nenartovich.Par;
import by.nenartovich.dao.ClientRepository;
import by.nenartovich.dao.ManagerRepository;
import by.nenartovich.dao.OrderRepository;
import by.nenartovich.dto.ManagerDto;
import by.nenartovich.dto.OrderDto;
import by.nenartovich.entity.Order;
import by.nenartovich.mappers.ManagerMapper;
import by.nenartovich.mappers.OrderMapper;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ManagerMapper managerMapper;
    private final OrderMapper orderMapper;

    public ManagerServiceImpl(ManagerRepository managerRepository, OrderRepository orderRepository, ClientRepository clientRepository, ManagerMapper managerMapper, OrderMapper orderMapper) {
        this.managerRepository = managerRepository;
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.managerMapper = managerMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public ManagerDto findById(Long managerId) {
        return managerMapper.managerToManagerDto(managerRepository.getReferenceById(managerId));
    }

    @Override
    public ManagerDto findByName(String managerName) {
        return managerMapper.managerToManagerDto(managerRepository.findByUserName(managerName));
    }

    @Override
    public List<ManagerDto> findAllManagerDto() {
        return managerRepository.findAll().stream()
                .map(managerMapper::managerToManagerDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getManagerOrders(Long managerId) {
        return managerRepository.getManagerOrders(managerId).stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getManagerOrders(String managerName) {
        return managerRepository.getManagerOrders(managerName).stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateManager(ManagerDto managerDto) {
        /*managerRepository.save(managerMapper.updateManagerFromManagerDto(managerDto
                ,managerRepository.getReferenceById(managerDto.getId())));*/
        managerRepository.save(managerMapper.managerDtoToManager(managerDto));
    }

    @Override
    public void createManager(Long managerId, String name) {

    }

    @Override
    public Page<OrderDto> findPaginated(Pageable pageable, Long managerId) {
        List<OrderDto> orders = getManagerOrders(managerId);
        List<OrderDto> list;
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        if (orders.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, orders.size());
            list = orders.subList(startItem, toIndex);
        }
        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), orders.size());
    }

    @Override
    public Page<OrderDto> findAllPaginated(int pageNumber, String sortField, String sortDirection, Long managerId) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable paged = PageRequest.of(pageNumber - 1, 5, sort);
        return orderRepository.findAll(paged).map(orderMapper::orderToOrderDto);
    }

    @Override
    //public Page<OrderDto> findAllPaginated(OrderFilter orderFilter, int pageNumber, int pageSize, String sortField, String sortDirection) {
    public Page<OrderDto> findAllPaginated(OrderFilter orderFilter, Par par) {
        Specification<Order> orderSpecification =
                Specification
                        .where(Optional.ofNullable(orderFilter.gDateCreateBefore())
                                .map(SpecificationOrder::getOrderByCreatDateBefore)
                                .orElse(null))
                        .and(Optional.ofNullable(orderFilter.gDateCreateFor())
                                .map(SpecificationOrder::getOrderByCreatDateFor)
                                .orElse(null))
                        .and(Optional.ofNullable(clientRepository.findByName(orderFilter.getClient()))
                                .map(SpecificationOrder::getOrderByClientSpec)
                                .orElse(null))
                        .and(Optional.ofNullable(managerMapper.managerDtoToManager(orderFilter.getManagerDto()))
                                .map(SpecificationOrder::getOrderByManagerSpec)
                                .orElse(null));
        Sort sort = par.getSortDir().equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(par.getSortField()).ascending()
                : Sort.by(par.getSortField()).descending();
        Pageable paged = PageRequest.of(par.getPageNumber() - 1, par.getPageSize(), sort);
        return orderRepository.findAll(orderSpecification, paged).map(orderMapper::orderToOrderDto);
    }
}
