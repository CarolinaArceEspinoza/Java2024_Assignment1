module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.assignment1 to javafx.fxml;
    exports org.example.assignment1;
    exports org.example.assignment1.model;
    opens org.example.assignment1.model to javafx.fxml;
    exports org.example.assignment1.controller;
    opens org.example.assignment1.controller to javafx.fxml;
}