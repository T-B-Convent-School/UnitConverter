package com.example.converter.core;

public class UnitConverter {
    public double convertLength(double value, LengthUnit from, LengthUnit to) {
        double meters = from.convertToMeters(value);
        return to.convertFromMeters(meters);
    }

    public double convertWeight(double value, WeightUnit from, WeightUnit to) {
        double kilograms = from.convertToKilograms(value);
        return to.convertFromKilograms(kilograms);
    }

    public double convertTemperature(double value, TemperatureUnit from, TemperatureUnit to) {
        if (from == to) {
            return value;
        }

        // Convert to Celsius first
        double celsius;
        switch (from) {
            case CELSIUS:
                celsius = value;
                break;
            case FAHRENHEIT:
                celsius = (value - 32) * 5 / 9;
                break;
            case KELVIN:
                celsius = value - 273.15;
                break;
            default:
                throw new IllegalArgumentException("Unknown temperature unit: " + from);
        }

        // Convert from Celsius to target unit
        switch (to) {
            case CELSIUS:
                return celsius;
            case FAHRENHEIT:
                return celsius * 9 / 5 + 32;
            case KELVIN:
                return celsius + 273.15;
            default:
                throw new IllegalArgumentException("Unknown temperature unit: " + to);
        }
    }
}