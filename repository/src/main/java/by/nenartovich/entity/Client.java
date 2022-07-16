package by.nenartovich.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "surname", length = 20)
    private String surname;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "patronymic", length = 20)
    private String patronymic;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Order> orders = new java.util.LinkedHashSet<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "surname = " + surname + ", " +
                "name = " + name + ", " +
                "patronymic = " + patronymic + ", " +
                "address = " + address + ")";
    }
}