package com.sakila.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/sakila";
    private static final String USER = "frank";
    private static final String PASSWORD = "admin.0709";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
