package org.example;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Position {
    @Id
    private int positionId;

    private String description;
}
