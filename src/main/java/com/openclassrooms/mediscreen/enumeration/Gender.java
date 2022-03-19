package com.openclassrooms.mediscreen.enumeration;

public enum Gender {
    FEMALE("F"),
    MALE("M");

    private final String symbol;
    Gender(String gender) {
        this.symbol = gender;
    }

    public String getSymbol() {
        return symbol;
    }
}
