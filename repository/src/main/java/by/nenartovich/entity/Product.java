package by.nenartovich.entity;

import by.nenartovich.Section;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "price", length = 6)
    private Double price;

    @Column(name = "section")
    @Convert(converter = SectionConverter.class)
    private Section section;
}
