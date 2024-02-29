package org.example.assignment1.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.assignment1.model.Characters;
import org.example.assignment1.model.DatabaseConnector;

import java.io.IOException;

/* CONTROLLER CLASS TO MANAGES THE FUNCTIONALITY OF characteristicsView.fxml */
public class TableViewController extends BasedController {

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
}