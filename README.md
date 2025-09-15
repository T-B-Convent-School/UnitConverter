
---

# Unit Converter

A JavaFX-based desktop application for converting units across various categories such as Length, Weight, and Temperature.

## Features

- Select a category (e.g., Length, Weight, Temperature)
- Choose units to convert from and to
- Input a value and view the converted result
- Swap units for quick reverse conversion

## Technologies Used

- **Java** – Core programming language  
- **JavaFX** – User interface framework  
- **Gradle** – Build automation tool

## Project Structure

```
UnitConverter/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.converter.ui.javafx.controller/
│   │   │       └── ConverterController.java
│   │   └── resources/
│   │       ├── ConverterView.fxml
│   │       └── styles.css
├── assets/
│   └── UC.png
├── build.gradle
├── gradlew
├── gradlew.bat
└── LICENSE
```

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/RohanDevOps/UnitConverter.git
   cd UnitConverter
   ```

2. Build the project using Gradle:
   ```bash
   ./gradlew build
   ```

3. Run the application:
   ```bash
   ./gradlew run
   ```

## Screenshot

The application interface:

`assets/UC.png`

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---
