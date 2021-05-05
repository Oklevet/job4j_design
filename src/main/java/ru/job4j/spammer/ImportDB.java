package ru.job4j.spammer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().forEach(p -> {
                String[] strs = p.split(";");
                if (strs.length == 2) {
                    users.add(new User(strs[0], strs[1]));
                }
            });
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            PreparedStatement prS = cnt.prepareStatement("create table if not exists users "
                    + "(name varchar(100), email varchar(100));");
            prS.execute();
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users (name, email) values (?, ?)",
                        Statement.RETURN_GENERATED_KEYS)) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
           try (PreparedStatement preparedStatement = cnt.prepareStatement(
                    "select * from users")) {
               preparedStatement.execute();
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println(
                                //Вывести записи вместе со сгенерированными id
                                //resultSet.getLong(1) + " " +
                                resultSet.getString("name") + "  " + resultSet.getString("email"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("src/data/app3.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "src/data/dump.txt");
        db.save(db.load());
    }
}