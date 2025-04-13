package com.example.converter.ui.model;

import com.example.converter.core.*;

public class ConverterModel {
    private final UnitConverter converter = new UnitConverter();

    public double convert(double value, ConversionCategory category, Object fromUnit, Object toUnit) {
        switch (category) {
            case LENGTH:
                return converter.convertLength(value, (LengthUnit) fromUnit, (LengthUnit) toUnit);
            case WEIGHT:
                return converter.convertWeight(value, (WeightUnit) fromUnit, (WeightUnit) toUnit);
            case TEMPERATURE:
                return converter.convertTemperature(value, (TemperatureUnit) fromUnit, (TemperatureUnit) toUnit);
            default:
                throw new IllegalArgumentException("Unsupported conversion category");
        }
    }
}