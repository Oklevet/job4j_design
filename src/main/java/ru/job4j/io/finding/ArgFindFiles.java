package ru.job4j.io.finding;

import java.util.HashMap;
import java.util.Map;

public class ArgFindFiles {
     private final Map<String, String> values = new HashMap<>();

    public ArgFindFiles(String[] args) {
        parse(args);
    }
    public void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Empty array of parameters.");
        }
        for (String s : args) {
            if (!(s.contains("=") && s.contains("jar"))) {
                throw new IllegalArgumentException("Wrong parameters.");
            }
            if (!(s.contains("=")) && s.contains("jar")) {
                if (s.startsWith("-")) {
                    values.put(s, null);
                } else {
                    if (values.containsKey("-jar")) {
                        values.put("-jar", s);
                    }
                }
            }
            String[] strs = s.split("=");
            if (strs.length == 1) {
                throw new IllegalArgumentException("No value in equality.");
            }
            values.put(strs[0].substring(1), strs[1]);
        }
    }

    public String getDirectory() {
        if (!values.containsKey("-d")) {
            throw new IllegalArgumentException("\"-d\" isn't entered.");
        }
        return values.get("-d");
    }

    public String getN() {
        if (!values.containsKey("-n")) {
            throw new IllegalArgumentException("\"-n\" isn't entered.");
        }
        return values.get("-n");
    }

    public String getMask() {
        if (!values.containsKey("-m")) {
            throw new IllegalArgumentException("\"-n\" isn't entered.");
        }
        return values.get("-n");
    }

    public String getLog() {
        if (!values.containsKey("-o")) {
            System.out.println("check -o");
            throw new IllegalArgumentException("\"-o\" isn't entered.");
        }
        return values.get("-o");
    }
}
