package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            List<String> finalList = new ArrayList<>();
            String timeFirst = "";
            List<String> list = reader
                                    .lines()
                                    .filter(s -> !s.isEmpty())
                                    .collect(Collectors.toList());
            for (String s : list) {
                String[] strs = s.split(" ");
                if ((s.startsWith("400") || s.startsWith("500")) && timeFirst.isEmpty()) {
                    timeFirst = strs[1] + ";";
                } else if (!(s.startsWith("400") || s.startsWith("500")) && timeFirst.endsWith(";")) {
                    finalList.add(timeFirst + strs[1]);
                    timeFirst = "";
                }
            }
            if (!timeFirst.isEmpty()) {
                finalList.add(timeFirst + " still not working");
            }
            writeToFile(finalList, target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(List<String> list, String target) {
        try (PrintWriter output = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            list.stream().forEach(s -> output.println(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
