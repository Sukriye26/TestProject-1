package org.example.Entity;

public enum Gender {
    KADIN("Kadın"),
    ERKEK("Erkek"),
    OTHER("Other");

    private String description;

    // Enum constructor
    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
