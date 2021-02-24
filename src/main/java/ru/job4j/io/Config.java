package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            List<String> list = reader
                    .lines()
                    .filter(not(s -> s.isEmpty() || s.substring(0, 1).equals("#")))
                    .collect(Collectors.toList());
            for (String s : list) {
                System.out.println(s);
                String[] strs = s.split("=", 2);
                if (strs[1].isEmpty()) {
                    throw new IllegalArgumentException();
                }
                values.put(strs[0], strs[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
