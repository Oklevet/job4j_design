package ru.job4j.collection.examination;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Класс получает на вход абсолютный путь документа, содержащего пользователей
 * и их почтовые ящики. Класс производит преобразование полученного документа
 * в список с записями(class Record)
 * @author NIK STARTSEV
 * @version 1.0
 */
public class GetProperty {
    private final String path;

    private final List<Record> values = new ArrayList<>();

    public GetProperty(final String path) {
        this.path = path;
    }

    /**
     * Преобразование для документа с данными которого предстоит произвести слияние
     * @return
     * @throws WrongFormatEmailsException
     */

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

    /**
     * Преобразование документа представляющего конечный, эталонный вариант после преобразование
     * Данный метод используется в автотестировании с объектами expected
     * @return
     * @throws WrongFormatEmailsException
     */
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