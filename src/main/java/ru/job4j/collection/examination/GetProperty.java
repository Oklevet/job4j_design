package ru.job4j.collection.examination;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GetProperty {
    private final String path;

    private final List<Record> values = new ArrayList<>();

    public GetProperty(final String path) {
        this.path = path;
    }

    public List<Record> loadMails() throws WrongFormatEmailsException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                String[] strs = s.split(" ->", 2);
                if (strs[1].isEmpty()) {
                    throw new IllegalArgumentException();
                }
                Set<String> set = new HashSet<>();
                Arrays.asList(strs[1].split(",")).forEach(ss -> set.add(ss));
                values.add(new Record(strs[0], set));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new WrongFormatEmailsException("Sent empty list of mails or invalid format. Sample: \"user ->email,email\""
                    + System.lineSeparator() + "Please recheck your file.");
        }
        return values;
    }
    public List<Record> loadEtalon() throws WrongFormatEmailsException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                String[] strs = s.split(" ", 2);
                if (strs[1].isEmpty()) {
                    throw new IllegalArgumentException();
                }
                Set<String> set = new HashSet<>();
                Arrays.asList(strs[1].split(", ")).forEach(ss -> set.add(ss));
                values.add(new Record(strs[0], set));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }
}
