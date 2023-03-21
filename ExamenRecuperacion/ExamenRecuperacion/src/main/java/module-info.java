module com.javier.examenrecuperacion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    
    opens models;

    opens com.javier.examenrecuperacion to javafx.fxml, java.sql;
    exports com.javier.examenrecuperacion;
}
