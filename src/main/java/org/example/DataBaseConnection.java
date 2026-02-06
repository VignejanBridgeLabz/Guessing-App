package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static Connection getConnection() {
        Connection con = null;

        try {
            String url = "jdbc:mysql://localhost:3306/GUESSING_APP";
            String host = "root";
            String password = "dinu";

            //load the driver class
//            Class.forName("com.mysql.cj.jdbc.Driver");

            //create the connection
            con = DriverManager.getConnection(url, host, password);

            System.out.println("DataBase Connected");

        }
        catch (SQLException e) {
            throw new RuntimeException("Database connection failed", e);
        }
        return con;
    }
}

