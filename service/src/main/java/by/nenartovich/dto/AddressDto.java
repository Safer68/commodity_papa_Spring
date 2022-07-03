package by.nenartovich.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDto implements Serializable {
    private final String city;
    private final String street;
    private final Integer postalCode;
}
