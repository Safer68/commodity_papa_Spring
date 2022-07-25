package by.nenartovich;


import by.nenartovich.dto.OrderDto;
import org.springframework.data.domain.Page;

public interface OrderService {
    OrderDto findById(Long orderId);

    void updateOrder(OrderDto orderDto);

    OrderDto save(OrderDto orderDto);

    Page<OrderDto> findAllPaginated(OrderFilter orderFilter, Parameter parameter);
}
