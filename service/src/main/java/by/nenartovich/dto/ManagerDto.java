package by.nenartovich.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ManagerDto implements Serializable {
    private final Long id;
    private final String name;
}
