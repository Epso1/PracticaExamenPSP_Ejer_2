module com.example.practica_5_ejer_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica_5_ejer_1 to javafx.fxml;
    exports com.example.practica_5_ejer_1;
}