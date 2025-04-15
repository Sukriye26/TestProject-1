package org.example;


public enum LeaveReason {
    ANNUAL("Annual"),
    PERSONAL("Personal"),
    BEREAVEMENT("Bereavement ");

    private String description;

    // Enum constructor
    LeaveReason(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

