package org.example.assignment1.controller;

import javafx.event.ActionEvent;
import org.example.assignment1.utils.Utils;

import java.io.IOException;

public class BasedController {

    /* NAVIGATION BAR OPTIONS */
    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        // Switch to 'tableView.fxml'
        Utils.switchSC(Utils.TABLE_PATH, actionEvent);
    }

    public void movieViewButton(ActionEvent actionEvent) throws IOException {
        // Switch to 'MovieView.fxml'
        Utils.switchSC(Utils.MOVIE_PATH, actionEvent);
    }

    public void kindViewButton(ActionEvent actionEvent) throws IOException {
        // Switch to 'characteristicsView.fxml'
        Utils.switchSC(Utils.CHARACTER_PATH, actionEvent);
    }
}
