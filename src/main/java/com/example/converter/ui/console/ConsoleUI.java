package com.example.converter.ui.console;

import com.example.converter.core.*;
import com.example.converter.ui.UI;

import java.util.Scanner;

public class ConsoleUI implements UI {
    private final UnitConverter converter;

    public ConsoleUI() {
        this.converter = new UnitConverter();
    }

    @Override
    public void start() {
        System.out.println("=== Unit Converter ===");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nSelect category:");
                for (ConversionCategory category : ConversionCategory.values()) {
                    System.out.println((category.ordinal() + 1) + ". " + category);
                }
                System.out.println((ConversionCategory.values().length + 1) + ". Exit");

                int choice;
                while (true) {
                    System.out.print("Enter your choice: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next(); // Clear invalid input
                        continue;
                    }
                    choice = scanner.nextInt();
                    if (choice >= 1 && choice <= ConversionCategory.values().length + 1) break;
                    System.out.println("Invalid choice. Please try again.");
                }

                if (choice == ConversionCategory.values().length + 1) break;

                ConversionCategory selectedCategory = ConversionCategory.values()[choice - 1];
                handleCategory(selectedCategory, scanner);
            }
        }
        System.out.println("Goodbye!");
    }

    private void handleCategory(ConversionCategory category, Scanner scanner) {
        switch (category) {
            case LENGTH:
                handleUnitConversion(LengthUnit.values(), scanner);
                break;
            case WEIGHT:
                handleUnitConversion(WeightUnit.values(), scanner);
                break;
            case TEMPERATURE:
                handleUnitConversion(TemperatureUnit.values(), scanner);
                break;
            default:
                System.out.println("Conversion type not yet implemented.");
        }
    }

    private <T extends Enum<T>> void handleUnitConversion(T[] units, Scanner scanner) {
        System.out.println("\nAvailable Units:");
        for (int i = 0; i < units.length; i++) {
            System.out.println((i + 1) + ". " + units[i]);
        }

        int fromIndex, toIndex;
        while (true) {
            System.out.print("Select source unit (1-" + units.length + "): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }
            fromIndex = scanner.nextInt() - 1;
            if (fromIndex >= 0 && fromIndex < units.length) break;
            System.out.println("Invalid choice. Please try again.");
        }
        T fromUnit = units[fromIndex];

        while (true) {
            System.out.print("Select target unit (1-" + units.length + "): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
                continue;
            }
            toIndex = scanner.nextInt() - 1;
            if (toIndex >= 0 && toIndex < units.length) break;
            System.out.println("Invalid choice. Please try again.");
        }
        T toUnit = units[toIndex];

        System.out.print("Enter value to convert: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear invalid input
        }
        double value = scanner.nextDouble();

        double result = performConversion(value, fromUnit, toUnit);
        displayResult(value, result, fromUnit.toString(), toUnit.toString());
    }

    @SuppressWarnings("unchecked")
    private <T extends Enum<T>> double performConversion(double value, T fromUnit, T toUnit) {
        if (fromUnit instanceof LengthUnit) {
            return converter.convertLength(value, (LengthUnit) fromUnit, (LengthUnit) toUnit);
        } else if (fromUnit instanceof WeightUnit) {
            return converter.convertWeight(value, (WeightUnit) fromUnit, (WeightUnit) toUnit);
        } else if (fromUnit instanceof TemperatureUnit) {
            return converter.convertTemperature(value, (TemperatureUnit) fromUnit, (TemperatureUnit) toUnit);
        }
        throw new IllegalArgumentException("Unsupported unit type");
    }

    @Override
    public void displayResult(double inputValue, double resultValue, String fromUnit, String toUnit) {
        System.out.printf("%.2f %s = %.2f %s%n", inputValue, fromUnit, resultValue, toUnit);
    }

    @Override
    public void showError(String title, String message) {
        System.err.printf("Error - %s: %s%n", title, message);
    }
}