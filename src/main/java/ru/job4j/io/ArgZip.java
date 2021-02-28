package ru.job4j.io;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length != 3) {
            throw new IllegalArgumentException("Arguments parameters: directory, exclude, output");
        }
        for (String s : args) {
            if (!s.contains("-d") || !s.contains("-e") || !s.contains("-o")) {
                throw new IllegalArgumentException("Arguments parameters: directory: -d, exclude: -e, output: -o");
            }
        }
        return true;
    }

    public String directory() {
        return this.findParam("-d").split("=")[1];
    }

    public String exclude() {
        return this.findParam("-e").split("=")[1];
    }

    public String output() {
        return this.findParam("-o").split("=")[1];
    }

    private String findParam(String symbol) {
        for (String s : args) {
            if (s.startsWith(symbol)) {
                return s;
            }
        }
        return null;
    }
}
