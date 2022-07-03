package by.nenartovich.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeliveryDto implements Serializable {
    private final Long id;
    private final String name;
}
