package by.nenartovich.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientDto implements Serializable {
    private final Long id;
    private final String surname;
    private final String name;
    private final String patronymic;
    private final String phoneNumber;
    private final AddressDto address;
}
