package by.nenartovich.entity;

import by.nenartovich.Section;
import by.nenartovich.utils.SectionConverter;
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

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "price", length = 6)
    private Double price;

    @Column(name = "section")
    @Convert(converter = SectionConverter.class)
    private Section section;

    @Column(name = "image", length = 40)
    private String image;

    @Column(name = "active")
    private boolean active;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
