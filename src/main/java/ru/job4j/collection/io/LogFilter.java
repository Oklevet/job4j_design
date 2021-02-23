package ru.job4j.collection.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            list = reader
                    .lines()
                    .filter(s -> s.contains(" 404 "))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void save(List<String> log, String file) {
        try {
            //PrintWriter output = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)));
            //BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            FileOutputStream output = new FileOutputStream(file);
//            for (String s : log) {
//                output.write(s.getBytes(StandardCharsets.UTF_8));
//                output.write(13);
//                output.write(10);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}
