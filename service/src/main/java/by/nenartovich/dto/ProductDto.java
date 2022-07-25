package by.nenartovich.dto;

import by.nenartovich.Section;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    private Long id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Длина должна быть от 2 до 30 символов.")
    private String name;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 255, message = "Длина должна быть от 2 до 255 символов.")
    private String description;

    @Min(value = 1, message = "Цена должна быть больше 0")
    private Double price;

    private Section section;

    private String image;

    private boolean active;
}
