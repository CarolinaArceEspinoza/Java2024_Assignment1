package org.assignment1.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    /* PROGRAM RUNS FROM HERE */
    /* It includes the first page to run, and the configuration of the window/stage where the program
       will run, title and icon */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tableView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1300, 700);
        Image image = new Image("file:src/main/resources/org/images/icon.png");
        stage.getIcons().add(image);
        stage.setTitle("Most Popular Marvel Characters");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}