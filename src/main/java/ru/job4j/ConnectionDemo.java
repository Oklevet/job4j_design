package ru.job4j;

import ru.job4j.io.serialization.json.B;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    private String url, password, login;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
         File file = new File(".app.properties");
         try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
             reader.lines().forEach(l -> {
                 String[] str = l.split("=");
                 if (str[0].equals("url")) {
                     String url = str[1];
                 }
                 if (str[0].equals("login")) {
                     String login = str[1];
                 }
                 if (str[0].equals("password")) {
                     String password = str[1];
                 }
             });
         } catch (IOException e) {
             e.printStackTrace();
         }
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new ConnectionDemo().connect();
    }
}