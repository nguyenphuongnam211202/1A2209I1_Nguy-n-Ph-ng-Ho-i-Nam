package com.example.service;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String URL = "jdbc:mysql://localhost:3306/exam";
    private static final String USENAME = "root";
    private static final String PASSWORD = "12345";

    public java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
        java.sql.Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL,USENAME,PASSWORD);
        return connection;
    }
}