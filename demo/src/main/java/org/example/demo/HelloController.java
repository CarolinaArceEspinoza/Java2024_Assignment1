package org.example.demo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class HelloController {

    @FXML
    DatabaseConnector dbConnector = new DatabaseConnector();

    @FXML
    private TableView<Characters> containerTable;

    @FXML
    private TableColumn<Characters, Integer> idColumn;

    @FXML
    private TableColumn<Characters, Integer> rankingColumn;

    @FXML
    private TableColumn<Characters, String> nameColumn;

    @FXML
    private TableColumn<Characters, String> movieColumn;

    @FXML
    private TableColumn<Characters, String> powerColumn;

    @FXML
    private TableColumn<Characters, String> kindColumn;

    @FXML
    private TableColumn<Characters, String> originColumn;

    @FXML
    private TableColumn<Characters, String> speciesColumn;

    @FXML
    ObservableList<Characters> items;

    private static Connection conexion = null;

    // Initialize method to set up the table columns
    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        rankingColumn.setCellValueFactory(new PropertyValueFactory<>("ranking"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        movieColumn.setCellValueFactory(new PropertyValueFactory<>("movie"));
        powerColumn.setCellValueFactory(new PropertyValueFactory<>("power"));
        originColumn.setCellValueFactory(new PropertyValueFactory<>("origin"));
        speciesColumn.setCellValueFactory(new PropertyValueFactory<>("species"));
        kindColumn.setCellValueFactory(new PropertyValueFactory<>("kind"));

        Characters characters = new Characters();
        ObservableList<Characters> items = characters.getCharactersFromDatabase(); // Obtener los datos de la base de datos
        this.containerTable.setItems(items);


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