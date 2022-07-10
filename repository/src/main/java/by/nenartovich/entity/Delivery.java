package by.nenartovich.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    /*@OneToMany(mappedBy = "delivery", orphanRemoval = true)*/
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.MERGE)
    private List<Order> orders = new ArrayList<>();

}