package by.nenartovich.dto;

import by.nenartovich.Section;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Section section;
    private String image;
    private boolean active;
}
