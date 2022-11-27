package ru.job4j.io;

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

    public int getSize() {
        return values.size();
    }

    public boolean containKey(String key) {
        return values.containsKey(key);
    }

    public String getValue(String key) {
        return values.get(key);
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
