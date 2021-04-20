package ru.job4j.sql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public Properties getProperties() {
        return properties;
    }

    private void doQuery(String sql) throws SQLException {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute(sql);
            }
        }
    }

    private void initConnection() {
        String driver = (String) properties.get("driver");
        String url = (String) properties.get("url");
        String user = (String) properties.get("login");
        String password = (String) properties.get("password");
        System.out.println(driver);
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName, String columnName, String s) {
        String sql = String.format("create table %s (%s, %s);",
            tableName, columnName, s);
    }

    public void dropTable(String tableName) {
                String sql = String.format("drop table %s);", tableName);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format(
                        "alter table %s add column %s, %s;",
                tableName, columnName, type);
    }

    public void dropColumn(String tableName, String columnName) {
                String sql = String.format(
                        "alter table %s drop column %s;", tableName, columnName);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
                String sql = String.format(
                        "alter table %s rename column %s to %s;",
                        tableName, columnName, newColumnName);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/data/ddl.properties");) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (TableEditor tableEditor = new TableEditor(properties)) {
            tableEditor.createTable("table1", "name", "varchar(255)");
            tableEditor.addColumn("table1", "count", "int");
            tableEditor.renameColumn("table1", "count", "quantity");
            tableEditor.dropColumn("table1", "quantity");
            tableEditor.dropTable("table1");
            System.out.println(tableEditor.getScheme("table1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
