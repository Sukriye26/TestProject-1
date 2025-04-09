package org.example.Entity;

public enum Status {
    JUNIOR("Junior"),
    MID_LEVEL("Mid-Level"),
    SENIOR("Senior-1");

    private String description;

    // Enum constructor
    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
