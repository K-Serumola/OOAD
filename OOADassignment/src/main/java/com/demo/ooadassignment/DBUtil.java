package com.demo.ooadassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/bankappdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ilikedogs";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
