package com.example.converter.core;

public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    MILLIGRAM(0.000001),
    POUND(0.453592),
    OUNCE(0.0283495);

    private final double toKilogramFactor;

    WeightUnit(double toKilogramFactor) {
        this.toKilogramFactor = toKilogramFactor;
    }

    public double convertToKilograms(double value) {
        return value * toKilogramFactor;
    }

    public double convertFromKilograms(double kilograms) {
        return kilograms / toKilogramFactor;
    }
}