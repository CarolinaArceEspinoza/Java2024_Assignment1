package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class KindViewController implements Initializable {

    @FXML
    private PieChart pieChart;

    private void loadChartDataFromDatabase(String dataSelector) {
        pieChart.getData().clear(); // Limpiar los datos actuales del gráfico

        try (Connection connection = new DatabaseConnector().connect()) {
            String query = "SELECT " + dataSelector + ", COUNT(*) AS count FROM CHARACTERS GROUP BY " + dataSelector + " ORDER BY count DESC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String data = resultSet.getString(dataSelector);
                int count = resultSet.getInt("count");
                pieChart.getData().add(new PieChart.Data(data, count));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tableView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void powerViewButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("powerView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void kindViewButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("kindView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private RadioButton kindRadioButton;

    @FXML
    private RadioButton speciesRadioButton;

    @FXML
    private RadioButton originRadioButton;

    @FXML
    private ToggleGroup toggleGroup; // Define un grupo para los botones de radio

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggleGroup = new ToggleGroup(); // Inicializa el grupo

        // Asigna el grupo a los botones de radio
        kindRadioButton.setToggleGroup(toggleGroup);
        speciesRadioButton.setToggleGroup(toggleGroup);
        originRadioButton.setToggleGroup(toggleGroup);

        // Agrega un listener para manejar los eventos de cambio de selección
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                // Si no hay nada seleccionado, deselecciona todos los botones
                toggleGroup.selectToggle(oldValue); // Esto desmarca el botón anterior
            }
        });
    }

    @FXML
    void handleRadioButtonAction(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) event.getSource();
        if (selectedRadioButton.isSelected()) {
            loadChartDataFromDatabase(selectedRadioButton.getId()); // Id del botón radio
        }
    }










}
