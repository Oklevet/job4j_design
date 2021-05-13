package ru.job4j.io.finding;

import java.util.HashMap;
import java.util.Map;

public class ArgFindFiles {
     private Map<String, String> values = new HashMap<>();

    public ArgFindFiles(String[] args) {
        System.out.println(args.length);
        for (int i = 0; i < args.length - 1; i++) {
            String par = args[i + 1];
            if (args[i].equals("-jar") && par.charAt(0) != '-') {
                values.put(args[i], par);
            }
            if (args[i].equals("-d") && par.charAt(0) != '-') {
                values.put(args[i], par);
            }
            if (args[i].equals("-n") && par.charAt(0) != '-') {
                values.put(args[i], par);
            }
            if (args[i].equals("-m")) {
                values.put(args[i], args[i]);
            }
            if (args[i].equals("-f")) {
                values.put(args[i], args[i]);
            }
            if (args[i].equals("-r")) {
                values.put(args[i], args[i]);
            }
            if (args[i].equals("-o") && par.charAt(0) != '-') {
                System.out.println("find args -o");
                values.put(args[i], par);
            }
        }
    }

    public Map<String, String> getValues() {
        return values;
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
