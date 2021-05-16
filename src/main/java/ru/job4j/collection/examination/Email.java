package ru.job4j.collection.examination;

import java.util.*;

/**
 * Класс выполняет слияние почтовых ящиков.
 * Если у двух пользователей есть общий email, значит это один и тот же пользователь.
 * @author NIK STARTSEV
 * @version 1.0
 */
public class Email {
    /**
     * Лист хранит записи типа: пользователь: {список ящиков}
     */
    List<Record> emails = new ArrayList<>();

    /**
     * @param path - абсолютный путь к файлу - списку пользователей.
     */
    public Email(String path) throws WrongFormatEmailsException {
        this.emails = new GetProperty(path).loadMails();
    }

    /**
     * Метод выполняет слияние пользователей.
     * @param mails - список полученный из предоставленного файла
     * @return
     */
    public static List<Record> union(List<Record> mails) {
        for (int i = mails.size() - 1; i >= 0; i--) {
            for (int j = mails.size() - 1; j > 0; j--) {
                if (i == j) {
                    break;
                }
                if (!Collections.disjoint(mails.get(i).getSet(), mails.get(j).getSet())) {
                    mails.get(i).getSet().addAll(mails.get(j).getSet());
                    mails.get(j).setSet(new HashSet<>());
                }
            }
        }
        return mails;
    }

    /**
     * Метод выводящий список пользователей и их ящиков в консоль
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Record r : emails) {
            if (r.getSet().size() > 0) {
                sb.append(r.getName().toString() + " ");
                Iterator value = r.getSet().iterator();
                sb.append(value.next());
                while (value.hasNext()) {
                    sb.append(", ");
                    sb.append(value.next());
                }
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws WrongFormatEmailsException {

    }
}
