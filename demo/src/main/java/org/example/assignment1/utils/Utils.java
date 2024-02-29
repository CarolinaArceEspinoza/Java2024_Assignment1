package org.example.assignment1.utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Utils {

    public static final String TABLE_PATH = "src/main/resources/org/example/assignment1/tableView.fxml";
    public static final String MOVIE_PATH = "src/main/resources/org/example/assignment1/MovieView.fxml";
    public static final String CHARACTER_PATH = "src/main/resources/org/example/assignment1/characteristicsView.fxml";

    /* SWITCHES TO A DIFFERENT SCENE BASED ON THE FXML FILE NAME */
    public static void switchSC(String fxmlFileName, ActionEvent actionEvent) throws IOException {
        URL url = new File(fxmlFileName).toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root,1300, 700);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}