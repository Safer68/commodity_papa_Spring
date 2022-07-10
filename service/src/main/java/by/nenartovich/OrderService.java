package by.nenartovich;



import by.nenartovich.dto.ClientDto;
import by.nenartovich.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    OrderDto findById(Long orderId);

    List<OrderDto> findAllOrderDto();

    void updateOrder(OrderDto orderDto);
    OrderDto save(OrderDto orderDto);
    Page<OrderDto> findPaginated(Pageable pageable);
    Page<OrderDto> findAllPaginated(int pageNumber, String sortField, String sortDirection);
}
