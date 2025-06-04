package ru.job4j.tasks.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CLParser {
    private final String[] args;

    public CLParser(String[] args) {
        this.args = args;
    }

    public List<String> inputs() {
        List<String> list = new ArrayList<>();
        if (isAddMode()) {
            for (int i = getLastKey() + 1; i < args.length; i++) {
                if (args[i].contains(".")) {
                    list.add(args[i]);
                }
            }
        }
        return list;
    }

    public String prefix() {
        String res = null;
        if (hasPrefix()) {
            for (int i = getLastKey() + 1; i < args.length; i++) {
                if (!args[i].contains("/") && !args[i].contains(".")) {
                    return args[i];
                }
            }
        }
        return res;
    }

    public int getIdByStr(String str) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public int getLastKey() {
        for (int i = args.length - 1; i >= 0; i--) {
            if (args[i].startsWith("-")) {
                return i;
            }
        }
        return -1;
    }

    public boolean isAddMode() {
        return Arrays.asList(args).contains("-a");
    }

    public boolean hasOutputPath() {
        return Arrays.asList(args).contains("-o");
    }

    public String outputPath() {
        String res = null;
        if (hasOutputPath()) {
            for (int i = getLastKey() + 1; i < args.length; i++) {
                if (args[i].contains("/")) {
                    return args[i];
                }
            }
        }
        return res;
    }

    public boolean hasPrefix() {
        return Arrays.asList(args).contains("-p");
    }

    public boolean isShortStatistic() {
        return Arrays.asList(args).contains("-s");
    }

    public boolean parse() {
        return false;
    }

    public List<String> description() {
        List<String> list = new ArrayList<>();

        if (!isShortStatistic() && !isFullStatistic()) {
            list.add("Don't config statistic flags -s of -f.");
        }

        if (!isHasInputFiles()) {
            list.add("Don't contains input files.");
        }

        return list;
    }

    public boolean isHasInputFiles() {
        for (int i = getLastKey() + 1; i < args.length; i++) {
            if (args[i].contains(".")) {
                return true;
            }
        }
        return false;
    }

    public boolean isFullStatistic() {
        return Arrays.asList(args).contains("-f");
    }
}