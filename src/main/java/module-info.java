module com.mycompany.gatoteca1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.gatoteca1 to javafx.fxml;
    exports com.mycompany.gatoteca1;
}
