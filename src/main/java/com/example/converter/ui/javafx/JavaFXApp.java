package com.example.converter.ui.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class JavaFXApp extends Application {
    @Override
    public void start(Stage stage) {
        URL fxmlLocation = getClass().getResource("/com/example/converter/javafx/view/ConverterView.fxml");
        if (fxmlLocation == null) {
            System.err.println("Error: FXML file '/com/example/converter/javafx/view/ConverterView.fxml' not found.");
            System.exit(1); // Exit the application with an error code
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            System.err.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1); // Exit the application with an error code
            return; // This return is redundant but ensures clarity
        }

        stage.setTitle("Unit Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}