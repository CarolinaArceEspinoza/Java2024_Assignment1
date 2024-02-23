package org.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5686381";
    private static final String USER = "sql5686381";
    private static final String PASS = "8GPctZkUNr";
    public Connection connect() { try {
        return DriverManager.getConnection(URL, USER, PASS); } catch (SQLException e) {
        throw new RuntimeException("Error connecting to the database", e); }
    }
}