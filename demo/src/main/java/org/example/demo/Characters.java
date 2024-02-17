package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.*;

public class Characters {

    private Integer id;
    private Integer ranking;
    private String name;
    private String kind;
    private String movie;
    private String power;
    private String origin;
    private String species;


    public Characters() {
    }

    public Characters(Integer id, Integer ranking, String name, String kind, String movie, String power, String origin, String species) {
        this.id = id;
        this.ranking = ranking;
        this.name = name;
        this.kind = kind;
        this.movie = movie;
        this.power = power;
        this.origin = origin;
        this.species = species;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRanking() {
        return ranking;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public String getMovie() {
        return movie;
    }

    public String getPower() {
        return power;
    }

    public String getOrigin() {
        return origin;
    }

    public String getSpecies() {
        return species;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    DatabaseConnector dbConnector = new DatabaseConnector();

    public ObservableList<Characters> getCharactersFromDatabase() {
        ObservableList<Characters> personaList = FXCollections.observableArrayList();

        try {
            Connection connection = dbConnector.connect();
            String SQL = "SELECT * FROM Characters";
            Statement stmt = connection.createStatement();
            ResultSet resul = stmt.executeQuery(SQL);

            while (resul.next()) {
                Integer id = resul.getInt("id");
                Integer ranking = resul.getInt("ranking");
                String name = resul.getString("name");
                String kind = resul.getString("kind");
                String movie = resul.getString("movie");
                String power = resul.getString("power");
                String origin = resul.getString("origin");
                String species = resul.getString("species");

                Characters character = new Characters(id, ranking, name, kind, movie, power, origin, species);
                personaList.add(character);
            }

            stmt.close();
            resul.close();
            connection.close();
        } catch (SQLException e) {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("AVISO");
            alerta.setContentText(e + "");
            alerta.showAndWait();
        }

        return personaList;
    }

}
