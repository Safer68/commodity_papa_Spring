package by.nenartovich.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto implements Serializable {
    private  Long id;
    private  String surname;
    private  String name;
    private  String patronymic;
    private  String phoneNumber;
    private  AddressDto address;
}
