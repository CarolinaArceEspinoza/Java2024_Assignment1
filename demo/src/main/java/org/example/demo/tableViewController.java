package org.example.demo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

/* CONTROLLER CLASS TO MANAGES THE FUNCTIONALITY OF characteristicsView.fxml */
public class tableViewController {

    @FXML
    DatabaseConnector dbConnector = new DatabaseConnector(); //connection to database

    @FXML
    private TableView<Characters> containerTable;  // Table for data visualization

    @FXML
    private TableColumn<Characters, Integer> idColumn;  // Field: id

    @FXML
    private TableColumn<Characters, Integer> rankingColumn; // Field: ranking

    @FXML
    private TableColumn<Characters, String> nameColumn; // Field: name

    @FXML
    private TableColumn<Characters, String> movieColumn; // Field: movie

    @FXML
    private TableColumn<Characters, String> powerColumn; // Field: power

    @FXML
    private TableColumn<Characters, String> kindColumn; // Field: kind

    @FXML
    private TableColumn<Characters, String> originColumn; // Field: origin

    @FXML
    private TableColumn<Characters, String> speciesColumn; // Field: species


    /* INITIALIZES THE CONTROLLER, SET UP TABLE COLUMN VALUES */
    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id")); //Set Value: id
        rankingColumn.setCellValueFactory(new PropertyValueFactory<>("ranking"));  //Set Value: ranking
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name")); //Set Value: name
        movieColumn.setCellValueFactory(new PropertyValueFactory<>("movie")); //Set Value: movie
        powerColumn.setCellValueFactory(new PropertyValueFactory<>("power")); //Set Value: power
        originColumn.setCellValueFactory(new PropertyValueFactory<>("origin")); //Set Value: origin
        speciesColumn.setCellValueFactory(new PropertyValueFactory<>("species")); //Set Value: species
        kindColumn.setCellValueFactory(new PropertyValueFactory<>("kind")); //Set Value: kind

        Characters characters = new Characters();
        ObservableList<Characters> items = characters.getCharactersFromDatabase(); // Retrieve data from the database
        this.containerTable.setItems(items);

    }

    /* NAVIGATION BAR OPTIONS */
    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        // Switch to 'tableView.fxml'
        switchScene("tableView.fxml", actionEvent);
    }

    public void movieViewButton(ActionEvent actionEvent) throws IOException {
        // Switch to 'MovieView.fxml'
        switchScene("MovieView.fxml", actionEvent);
    }

    public void kindViewButton(ActionEvent actionEvent) throws IOException {
        // Switch to 'characteristicsView.fxml'
        switchScene("characteristicsView.fxml", actionEvent);
    }

    /* SWITCHES TO A DIFFERENT SCENE BASED ON THE FXML FILE NAME */
    private void switchScene(String fxmlFileName, ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load(),1300, 700);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}