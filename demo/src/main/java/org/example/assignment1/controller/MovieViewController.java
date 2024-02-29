package org.example.assignment1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import org.example.assignment1.model.DatabaseConnector;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/* CONTROLLER CLASS TO MANAGES THE FUNCTIONALITY OF MovieView.fxml */
public class MovieViewController extends BasedController implements Initializable {
    @FXML
    private BarChart<String, Number> barChart; // Bar chart for data visualization

    @FXML
    private CategoryAxis xAxis; // Category axis for chart X values

    private ToggleGroup toggleGroup; // Toggle group to manage radio buttons

    @FXML
    private RadioButton movieRadioButton; // Radio button to choose 'movie' chart

    @FXML
    private RadioButton originRadioButton; // Radio button to choose 'origin' chart

    /* INITIALIZES THE CONTROLLER, SETS UP RADIO BUTTON GROUP, LOAD INITIAL DATA AND SETS DEFAULT SELECTION */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggleGroup = new ToggleGroup(); // Initialize the toggle group

        // Group radio buttons
        movieRadioButton.setToggleGroup(toggleGroup); // Option 1
        originRadioButton.setToggleGroup(toggleGroup); // Option 2
        loadChartDataFromDatabase("movie"); // Load initial chart data

        // Handle selection change event
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadioButton = (RadioButton) newValue; // Selected radio button
                loadChartDataFromDatabase(selectedRadioButton.getId()); // Load data based on the selected option
                updateChartLabels(selectedRadioButton.getId()); // Update chart labels based on the selected option
            }
        });

        movieRadioButton.setSelected(Boolean.TRUE); // Set default selection to 'movie'
    }

    /* LOADS CHART DATA FROM THE DATABASE BASED ON THE DATA SELECTOR */
    private void loadChartDataFromDatabase(String dataSelector) {
        barChart.getData().clear(); // Clear the existing chart data

        try (Connection connection = new DatabaseConnector().connect()) {
            String query = "SELECT SUBSTRING(" + dataSelector + ", 1, 22), COUNT(*) AS count FROM CHARACTERS GROUP BY " + dataSelector + " ORDER BY count DESC";

            PreparedStatement statement = connection.prepareStatement(query); // Prepare the SQL statement
            ResultSet resultSet = statement.executeQuery(); // Execute the query and obtain the result set

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(dataSelector.equals("origin") ? "Origin" : "Movie"); // Set series name based on data selector

            while (resultSet.next()) {
                String origin = resultSet.getString(1); // Get the substring
                int count = resultSet.getInt("count"); // Get the count of each value from the database
                series.getData().add(new XYChart.Data<>(origin, count)); // Add data from the database to the series
            }
            barChart.getData().add(series); // Add the series to the bar chart

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* UPDATES THE CHART LABELS BASED ON THE SELECTED OPTION */
    private void updateChartLabels(String option) {
        if (option.equals("origin")) {
            xAxis.setLabel("ORIGINS"); // Set X-axis label to 'Origins'
        } else if (option.equals("movie")) {
            xAxis.setLabel("MOVIES"); // Set X-axis label to 'Movies'
        }
    }

    @FXML
    void handleRadioButtonAction(ActionEvent event) {
        // Action is handled dynamically by the change listener attached to the toggle group
    }


}