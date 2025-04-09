package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class District {
    @Id
    private int districtId;

    private String districtName;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;
}