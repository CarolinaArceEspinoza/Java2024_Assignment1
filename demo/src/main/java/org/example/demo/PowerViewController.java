package org.example.demo;

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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PowerViewController implements Initializable {
    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    private ToggleGroup toggleGroup; // Define un grupo para los botones de radio

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggleGroup = new ToggleGroup(); // Inicializa el grupo

        // Asigna el grupo a los botones de radio
        movieRadioButton.setToggleGroup(toggleGroup);
        powerRadioButton.setToggleGroup(toggleGroup);

        // Agrega un listener para manejar los eventos de cambio de selección
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
                loadChartDataFromDatabase(selectedRadioButton.getId()); // Id del botón radio
                updateChartLabels(selectedRadioButton.getId());
            }
        });
    }

    private void loadChartDataFromDatabase(String dataSelector) {
        barChart.getData().clear(); // Limpiar los datos actuales del gráfico
        // Conectar a la base de datos y obtener datos
        try (Connection connection = new DatabaseConnector().connect()) {
            String query = "SELECT " + dataSelector + ", COUNT(*) AS count FROM CHARACTERS GROUP BY " + dataSelector + " ORDER BY count DESC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(dataSelector.equals("power") ? "Power" : "Movie"); // Cambiar el nombre de la serie según la opción seleccionada

            while (resultSet.next()) {
                String power = resultSet.getString(dataSelector);
                int count = resultSet.getInt("count");
                series.getData().add(new XYChart.Data<>(power, count));
            }
            barChart.getData().add(series);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateChartLabels(String option) {
        if (option.equals("power")) {
            xAxis.setLabel("Different Powers");
            barChart.setTitle("Powers by Character");
        } else if (option.equals("movie")) {
            xAxis.setLabel("Different Movies");
            barChart.setTitle("Movies by Character");
        }
    }

    @FXML
    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tableView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void powerViewButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("powerView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void kindViewButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("kindView.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private RadioButton movieRadioButton;

    @FXML
    private RadioButton powerRadioButton;

    @FXML
    void handleRadioButtonAction(ActionEvent event) {
        // Este método se invocará cuando se seleccione un botón de radio,
        // pero los cambios de datos y etiquetas de gráficos se manejan en el método initialize() con el listener del toggleGroup.
    }
}
