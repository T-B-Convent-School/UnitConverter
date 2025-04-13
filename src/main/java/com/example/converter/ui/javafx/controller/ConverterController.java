package com.example.converter.ui.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConverterController {

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private ComboBox<String> fromUnitComboBox;

    @FXML
    private ComboBox<String> toUnitComboBox;

    @FXML
    private TextField inputField;

    @FXML
    private TextField resultField;

    @FXML
    public void initialize() {
        categoryComboBox.getItems().addAll("Length", "Weight", "Temperature");
        categoryComboBox.setOnAction(event -> populateUnits());
    }

    private void populateUnits() {
        fromUnitComboBox.getItems().clear();
        toUnitComboBox.getItems().clear();

        String selectedCategory = categoryComboBox.getValue();
        if ("Length".equals(selectedCategory)) {
            fromUnitComboBox.getItems().addAll("Meter", "Kilometer", "Centimeter");
            toUnitComboBox.getItems().addAll("Meter", "Kilometer", "Centimeter");
        } else if ("Weight".equals(selectedCategory)) {
            fromUnitComboBox.getItems().addAll("Gram", "Kilogram", "Pound");
            toUnitComboBox.getItems().addAll("Gram", "Kilogram", "Pound");
        } else if ("Temperature".equals(selectedCategory)) {
            fromUnitComboBox.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
            toUnitComboBox.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
        }
    }

    @FXML
    private void onConvertButtonClick() {
        try {
            String category = categoryComboBox.getValue();
            String fromUnit = fromUnitComboBox.getValue();
            String toUnit = toUnitComboBox.getValue();
            String inputValue = inputField.getText();

            if (category == null || fromUnit == null || toUnit == null || inputValue.isEmpty()) {
                resultField.setText("Invalid input");
                return;
            }

            double value = Double.parseDouble(inputValue);
            double result = performConversion(value, fromUnit, toUnit);
            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException e) {
            resultField.setText("Invalid number");
        } catch (IllegalArgumentException e) {
            resultField.setText(e.getMessage());
        }
    }

    private double performConversion(double value, String fromUnit, String toUnit) {
        if (fromUnit.equals(toUnit)) {
            return value;
        }

        switch (fromUnit + " to " + toUnit) {
            case "Meter to Kilometer":
                return value / 1000;
            case "Kilometer to Meter":
                return value * 1000;
            case "Gram to Kilogram":
                return value / 1000;
            case "Kilogram to Gram":
                return value * 1000;
            case "Celsius to Fahrenheit":
                return (value * 9 / 5) + 32;
            case "Fahrenheit to Celsius":
                return (value - 32) * 5 / 9;
            case "Celsius to Kelvin":
                return value + 273.15;
            case "Kelvin to Celsius":
                return value - 273.15;
            default:
                throw new IllegalArgumentException("Unsupported conversion: " + fromUnit + " to " + toUnit);
        }
    }
}