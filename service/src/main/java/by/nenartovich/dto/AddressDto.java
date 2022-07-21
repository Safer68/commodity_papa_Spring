package by.nenartovich.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable {
    private String city;
    private String street;
    private Integer postalCode;
    private Integer house;
    private String building;
    private Integer appt;
}
