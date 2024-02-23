package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class KindViewController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadChartDataFromDatabase();
    }

    @FXML
    private PieChart pieChart;

    private void loadChartDataFromDatabase() {
        // Conectar a la base de datos y obtener datos
        try (Connection connection = new DatabaseConnector().connect()) {
            String query = "SELECT kind, COUNT(*) AS count FROM characters GROUP BY kind ORDER BY count DESC";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String kind = resultSet.getString("kind");
                int count = resultSet.getInt("count");
                pieChart.getData().add(new PieChart.Data(kind, count));
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
}
