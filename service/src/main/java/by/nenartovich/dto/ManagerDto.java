package by.nenartovich.dto;

import by.nenartovich.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class ManagerDto implements Serializable {
    private Long id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Длина должна быть от 2 до 30 символов.")
    private String name;
    private UserDto user;
}
