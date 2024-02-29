module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.assignment1.app to javafx.fxml;
    exports org.assignment1.app;
    exports org.assignment1.app.model;
    opens org.assignment1.app.model to javafx.fxml;
    exports org.assignment1.app.controller;
    opens org.assignment1.app.controller to javafx.fxml;
}