package org.example.demo;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadChartDataFromDatabase();
    }

    private void loadChartDataFromDatabase() {
        // Conectar a la base de datos y obtener datos
        try (Connection connection = new DatabaseConnector().connect()) {
            String query = "SELECT power, COUNT(*) AS count FROM characters GROUP BY power ORDER BY count DESC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Prevalence of powers");

            while (resultSet.next()) {
                String power = resultSet.getString("power");
                int count = resultSet.getInt("count");
                series.getData().add(new XYChart.Data<>(power, count));
            }

            barChart.getData().add(series);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}