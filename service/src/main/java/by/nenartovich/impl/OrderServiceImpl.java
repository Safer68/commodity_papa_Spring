package by.nenartovich.impl;


import by.nenartovich.OrderService;
import by.nenartovich.dao.OrderRepository;
import by.nenartovich.dto.OrderDto;

import by.nenartovich.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
