package com.example.assignmentsevlet.database;

import java.sql.*;

public class Database {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/player_evaluation";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection conn;
    private static Database instance;


    private Database() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    // Singleton method to get the single instance of Database
    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    // Get a Statement object
    public Statement getStatement() throws SQLException {
        return conn.createStatement();
    }

    // Get a PreparedStatement object
    public PreparedStatement getPrepareStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    // Get the connection
    public Connection getConnection() {
        return conn;
    }

    // Optionally, close the connection when done
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing the connection: " + e.getMessage());
        }
    }
}