package org.example.Entity;


public enum Reason {
    ANNUAL("Annual"),
    PERSONAL("Personal"),
    BEREAVEMENT("Bereavement ");

    private String description;

    // Enum constructor
    Reason(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

