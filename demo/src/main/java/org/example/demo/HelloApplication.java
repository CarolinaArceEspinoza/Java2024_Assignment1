package org.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("powerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image image = new Image("file:src/main/resources/org/example/images/icon.png");
        stage.getIcons().add(image);
        stage.setTitle("Most Popular Marvel Characters");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}