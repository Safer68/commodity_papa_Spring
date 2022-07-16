package by.nenartovich.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class ManagerDto implements Serializable {
    private final Long id;
    private final String name;
    private final UserDto user;
}
