package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Position {
    @Id
    private int positionId;

    private String description;
}
