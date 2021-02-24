package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            list = reader
                    .lines()
                    .filter(s -> !(s.isEmpty()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter output = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            String timeFirst = "";
            for (int i = 0; i < list.size(); i++) {
                String[] s = list.get(i).split(" ");
                if ((s[0].equals("400") || s[0].equals("500")) && timeFirst.isEmpty()) {
                    timeFirst = s[1];
                } else if (!(s[0].equals("400") || s[0].equals("500")) && !timeFirst.isEmpty()) {
                    String outer = timeFirst + ";" + s[1];
                    output.println(outer);
                    timeFirst = "";
                }

            }
            if (!timeFirst.isEmpty()) {
                output.print(timeFirst);
                output.println("; still not working");
            }
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
