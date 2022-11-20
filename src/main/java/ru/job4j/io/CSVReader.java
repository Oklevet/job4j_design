package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        List<List<String>> listOfFile = new ArrayList<>();
        String filter = argsName.get("filter");
        String out = argsName.get("out");

        try (BufferedReader reader = new BufferedReader(new FileReader(argsName.get("path")))) {
            while (reader.ready()) {
                List<String> listOfLine = new ArrayList<>();
                String line = reader.readLine();
                Scanner scanner = new Scanner(new ByteArrayInputStream(line.getBytes()))
                        .useDelimiter(argsName.get("delimiter"));
                while (scanner.hasNext()) {
                    listOfLine.add(scanner.next());
                }
                listOfFile.add(new ArrayList<>(listOfLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> listIdx = getFilterIdx(filter, listOfFile);
        String res = getOutString(listOfFile, listIdx, argsName.get("delimiter"));
        printOutFile(res, out);
    }

    public static void printOutFile(String res, String out) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(out, Charset.defaultCharset()))) {
            if (out.equals("consoleout")) {
                System.out.println(res);
            } else {
                writer.println(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getOutString(List<List<String>> listStrs, List<Integer> filterIdx, String delimiter) {
        StringBuilder res = new StringBuilder();
        String delim = "";
        for (List<String> list : listStrs) {
            res.append(delim);
            StringJoiner sj = new StringJoiner(delimiter);
            for (Integer i : filterIdx) {
                sj.add(list.get(i));
            }
            res.append(sj);
            delim = System.lineSeparator();
        }
        return String.valueOf(res);
    }

    public static List<Integer> getFilterIdx(String filter, List<List<String>> list) {
        List<Integer> filterIdx = new ArrayList<>();
        String[] filters = filter.split(",");
        for (int i = 0; i < list.get(0).size(); i++) {
            for (String sFilt : filters) {
                if (sFilt.equals(list.get(0).get(i))) {
                    filterIdx.add(i);
                }
            }
        }
        return filterIdx;
    }

    /**
     * ARGS
     * -path=source.csv -delimiter=;  -out=consoleout.txt -filter=name,age
     */
    public static void main(String[] args) throws Exception {
        ArgsName argsNames = ArgsName.of(args);
        ArgsName.validScanner(args);
        CSVReader.handle(argsNames);
    }
}
