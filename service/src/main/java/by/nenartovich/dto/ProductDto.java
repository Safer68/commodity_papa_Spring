package by.nenartovich.dto;

import by.nenartovich.Section;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
    private final Long id;
    private final String description;
    private final Double price;
    private final Section section;
}
