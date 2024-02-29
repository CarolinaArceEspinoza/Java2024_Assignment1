package org.assignment1.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BasedController {

    public final String TABLE_PATH = "src/main/resources/org/assignment1/app/tableView.fxml";
    public final String MOVIE_PATH = "src/main/resources/org/assignment1/app/MovieView.fxml";
    public final String CHARACTER_PATH = "src/main/resources/org/assignment1/app/characteristicsView.fxml";

    /* SWITCHES TO A DIFFERENT SCENE BASED ON THE FXML FILE NAME */
    public void switchSC(String fxmlFileName, ActionEvent actionEvent) throws IOException {
        URL url = new File(fxmlFileName).toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root,1300, 700);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /* NAVIGATION BAR OPTIONS */
    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        // Switch to 'tableView.fxml'
        switchSC(TABLE_PATH, actionEvent);
    }

    public void movieViewButton(ActionEvent actionEvent) throws IOException {
        // Switch to 'MovieView.fxml'
        switchSC(MOVIE_PATH, actionEvent);
    }

    public void kindViewButton(ActionEvent actionEvent) throws IOException {
        // Switch to 'characteristicsView.fxml'
        switchSC(CHARACTER_PATH, actionEvent);
    }
}
