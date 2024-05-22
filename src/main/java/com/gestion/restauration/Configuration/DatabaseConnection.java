package com.gestion.restauration.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static String username = System.getenv("DB_USERNAME");
    public static String password = System.getenv("DB_PASSWORD");
    public static String url = System.getenv("DB_URL");

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connection successful!");
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
