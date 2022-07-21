package by.nenartovich.entity;

import by.nenartovich.Section;
import by.nenartovich.StatusOrder;
import by.nenartovich.utils.SectionConverter;
import by.nenartovich.utils.StatusOrderConverter;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_of_creation")
    private Date dateCreate = new Date();

    @Column(name = "date_of_change")
    @Builder.Default
    private Date dateChange = new Date();
    @Column(name = "price")
    private Double price;

    @ManyToMany
    @JoinTable(name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> products = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Column(name = "status_order")
    @Convert(converter = StatusOrderConverter.class)
    private StatusOrder statusOrder;

    @Embedded
    private Address addressDelivery;

    @Column(name = "track_number")
    private String trackNumber;

    @ElementCollection
    @CollectionTable(name = "product_amount", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "productt")
    private Map<Product, Integer> productMap;

}
