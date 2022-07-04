package by.nenartovich;



import by.nenartovich.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto findById(Long orderId);

    List<OrderDto> findAllOrderDto();

    void updateOrder(OrderDto orderDto);
    void saveOrder(OrderDto orderDto);
}
