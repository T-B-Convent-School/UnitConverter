package com.example.converter;

import com.example.converter.ui.console.ConsoleUI;
import com.example.converter.ui.javafx.JavaFXApp;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("console")) {
            new ConsoleUI().start();
        } else {
            JavaFXApp.launch(JavaFXApp.class, args);
        }
    }
}