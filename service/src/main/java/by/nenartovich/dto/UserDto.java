package by.nenartovich.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String userName;
    private final boolean active;
}
