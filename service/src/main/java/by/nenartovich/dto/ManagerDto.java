package by.nenartovich.dto;

import by.nenartovich.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class ManagerDto implements Serializable {
    private Long id;
    private String name;
    private UserDto user;
}
