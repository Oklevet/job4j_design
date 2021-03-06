package ru.job4j.sql;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class ConnectionDemo {
    private String url, password, login;

    public void connect(Config map) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        map.load();
        url = map.value("url");
        password = map.value("password");
        login = map.value("login");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new ConnectionDemo().connect(new Config("src/data/app.properties"));
    }
}