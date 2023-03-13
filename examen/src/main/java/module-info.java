module com.mycompany.examen {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.examen to javafx.fxml;
    exports com.mycompany.examen;
}
