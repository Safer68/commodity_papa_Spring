package by.nenartovich.dto;

import by.nenartovich.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
/*@NoArgsConstructor*/
public class ManagerDto implements Serializable {
    private final Long id;
    private final String name;
   /* private List<OrderDto> orders;*/
}
