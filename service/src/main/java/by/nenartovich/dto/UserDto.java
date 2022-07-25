package by.nenartovich.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserDto implements Serializable {
    private final Long id;
    private final String userName;
    private final boolean active;
}
