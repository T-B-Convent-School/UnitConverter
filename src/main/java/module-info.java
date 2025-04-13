module com.example.converter {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.converter.ui.javafx.controller to javafx.fxml;
    opens com.example.converter.ui.javafx to javafx.graphics;
}