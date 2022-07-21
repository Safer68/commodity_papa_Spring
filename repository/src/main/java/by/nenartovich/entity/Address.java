package by.nenartovich.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Address {
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private Integer house;

    @Column(name = "building")
    private String building;

    @Column(name = "appt")
    private Integer appt;

    @Column(name = "postal_code")
    private Integer postalCode;
}