package ru.job4j.io;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

     private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Empty array of parameters.");
        }
        for (String s : args) {
            if (!s.contains("=")) {
                throw new IllegalArgumentException("Wrong parameters.");
            }
            String[] strs = s.split("=");
            if (strs.length == 1) {
                throw new IllegalArgumentException("No value in equality.");
            }
            values.put(strs[0].substring(1), strs[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void validScanner(String[] argsName) {
        if (argsName.length != 4) {
            throw new IllegalArgumentException("Arguments parameters: directory, exclude, output");
        }
        for (String s : argsName) {
            if (!(s.contains("-path") || s.contains("-out") || s.contains("-delimiter") || s.contains("-filter"))) {
                throw new IllegalArgumentException("Arguments parameters: path, delimiter, out, filter");
            }
        }
        Path start = Paths.get(argsName[0].split("=")[1]);
        if (!start.toFile().exists()) {
            throw new IllegalArgumentException("File is not exist.   " + start.toAbsolutePath());
        }
        if (argsName[1].equals(";")) {
            throw new IllegalArgumentException("Delimiter should be ';'");
        }
        Path destination = Paths.get(argsName[2].split("=")[1]);
        if (!destination.toFile().exists()) {
            throw new IllegalArgumentException("File is not exist.   " + destination.toAbsolutePath());
        }
    }


    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
