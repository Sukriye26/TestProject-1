package org.example;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    private int addressId;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @ManyToOne
    @JoinColumn(name = "districtId")
    private District district;

    private String neighboord;
    private String street;
    private String buildingNumber;
    private String floor;
    private String doorNumber;
    private String description;
}
