package by.nenartovich.dto;

import by.nenartovich.entity.Order;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ManagerDto implements Serializable {
    private final Long id;
    private final String name;
   /* private List<OrderDto> orders;*/
}
