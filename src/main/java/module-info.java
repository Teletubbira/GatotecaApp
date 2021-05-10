module com.mycompany.gatoteca1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;

    opens com.mycompany.gatoteca1 to javafx.fxml;
    exports com.mycompany.gatoteca1;
}
