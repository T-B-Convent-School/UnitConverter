package com.example.converter.ui;

/**
 * Interface for all UI implementations of the Unit Converter.
 * Ensures consistent behavior across different interfaces.
 */
public interface UI {

    /**
     * Starts the user interface and begins interaction with the user.
     */
    void start();

    /**
     * Displays an error message to the user.
     * @param title The title of the error message
     * @param message The content of the error message
     */
    void showError(String title, String message);

    /**
     * Displays the conversion result to the user.
     * @param result The converted value
     * @param fromValue The original value
     * @param fromUnit The original unit
     * @param toUnit The target unit
     */
    void displayResult(double result, double fromValue, String fromUnit, String toUnit);
}