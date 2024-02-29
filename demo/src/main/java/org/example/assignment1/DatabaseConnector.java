package org.example.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    /* CONNECTION TO ONLINE DATABASE
    private static final String URL = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5686381";
    private static final String USER = "sql5686381";
    private static final String PASS = "8GPctZkUNr";
    public Connection connect() { try {
        return DriverManager.getConnection(URL, USER, PASS); } catch (SQLException e) {
        throw new RuntimeException("Error connecting to the database", e); }
    }
}*/


    /* CONNECTION TO LOCAL DATABASE*/

    private static final String URL = "jdbc:mysql://localhost:3305/caroarce_marvelCharacters";
    private static final String USER = "root";
    private static final String PASS = "";
    public Connection connect() { try {
        return DriverManager.getConnection(URL, USER, PASS); } catch (SQLException e) {
        throw new RuntimeException("Error connecting to the database", e); }
    }
}
