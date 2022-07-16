package by.nenartovich;


import by.nenartovich.dto.OrderDto;
import org.springframework.data.domain.Page;

public interface OrderService {
   /* OrderDto findById(Long orderId);

    List<OrderDto> findAllOrderDto();

    void updateOrder(OrderDto orderDto);*/

    OrderDto save(OrderDto orderDto);

    /*Page<OrderDto> findPaginated(Pageable pageable);*/

    Page<OrderDto> findAllPaginated(OrderFilter orderFilter, Parameter parameter);
}
