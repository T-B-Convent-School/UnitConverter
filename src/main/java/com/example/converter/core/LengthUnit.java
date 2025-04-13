package com.example.converter.core;

public enum LengthUnit {
    METER(1.0),
    KILOMETER(1000.0),
    CENTIMETER(0.01),
    MILLIMETER(0.001),
    MILE(1609.34),
    YARD(0.9144),
    FOOT(0.3048),
    INCH(0.0254);

    private final double toMeterFactor;

    LengthUnit(double toMeterFactor) {
        this.toMeterFactor = toMeterFactor;
    }

    public double convertToMeters(double value) {
        return value * toMeterFactor;
    }

    public double convertFromMeters(double meters) {
        return meters / toMeterFactor;
    }
}