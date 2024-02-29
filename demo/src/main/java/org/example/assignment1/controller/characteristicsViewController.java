package org.example.assignment1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import org.example.assignment1.model.DatabaseConnector;
import org.example.assignment1.utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/* CONTROLLER CLASS TO MANAGES THE FUNCTIONALITY OF characteristicsView.fxml */
public class characteristicsViewController implements Initializable {

    @FXML
    private PieChart pieChart; // Pie chart object for data visualization

    @FXML
    private RadioButton kindRadioButton;  // Radio button to choose chart by 'kind'

    @FXML
    private RadioButton speciesRadioButton;  // Radio button to choose chart by 'species'

    @FXML
    private RadioButton powerRadioButton;  // Radio button to choose chart by 'power'

    @FXML
    private ToggleGroup toggleGroup; // Toggle group to manage radio button selection

    /* INITIALIZES THE CONTROLLER, SETS UP RADIO BUTTON GROUP, LOAD INITIAL DATA AND SETS DEFAULT SELECTION */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggleGroup = new ToggleGroup(); // Initialize the toggle group

        // Group radio buttons
        kindRadioButton.setToggleGroup(toggleGroup); // Option 1
        speciesRadioButton.setToggleGroup(toggleGroup); // Option 2
        powerRadioButton.setToggleGroup(toggleGroup); // Option 3
        loadChartDataFromDatabase("kind");  // Load initial chart data

        // Handle selection change event
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                // If nothing is selected, revert to the previous selection
                toggleGroup.selectToggle(oldValue); // Deselect the previous button
            }
        });
        kindRadioButton.setSelected(Boolean.TRUE); // Set 'kind' as the initial selection
    }

    /* LOADS CHART DATA FROM THE DATABASE BASED ON THE DATA SELECTOR */
    private void loadChartDataFromDatabase(String dataSelector) {
        pieChart.getData().clear(); // Clear current chart data

        // Retrieve data from the database using a query
        try (Connection connection = new DatabaseConnector().connect()) {
            String query = "SELECT " + dataSelector + ", COUNT(*) AS count FROM CHARACTERS GROUP BY " + dataSelector + " ORDER BY count DESC";
            PreparedStatement statement = connection.prepareStatement(query); // Prepare the statement
            ResultSet resultSet = statement.executeQuery(); // Execute the query and obtain the result set

            while (resultSet.next()) {
                String data = resultSet.getString(dataSelector); // Get the string data
                int count = resultSet.getInt("count"); // Get the count of each value from the database
                pieChart.getData().add(new PieChart.Data(data, count)); // Add data from the database to the chart
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* RADIO BUTTONS TO CHANGE THE CHART */
    @FXML
    void handleRadioButtonAction(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) event.getSource();
        if (selectedRadioButton.isSelected()) {
            loadChartDataFromDatabase(selectedRadioButton.getId()); // Load data based on the selected radio button's ID
        }
    }
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