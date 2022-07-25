package by.nenartovich.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable {

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Длина должна быть от 2 до 30 символов.")
    private String city;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Длина должна быть от 2 до 30 символов.")
    private String street;

    @Min(value = 6, message = "Индекс должен быть 6 символов")
    @Max(value = 6, message = "Индекс должен быть 6 символов")
    private Integer postalCode;

    @Min(value = 1, message = "Номер дома должен быть от 1 до 999")
    @Max(value = 3, message = "Номер дома должен быть от 1 до 999")
    private Integer house;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 10, message = "Длина должна быть от 2 до 30 символов.")
    private String building;

    @Min(value = 1, message = "Номер квартиры должен быть от 1 до 999")
    @Max(value = 3, message = "Номер квартиры должен быть от 1 до 999")
    private Integer appt;
}
