package ru.job4j.collection.examination.ver2;

import ru.job4j.collection.examination.WrongFormatEmailsException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class EmailVer21 {
    private final String path;
    private Map<String, Set<String>> direct = new TreeMap<>();
    String findUser = "";

    public EmailVer21(String path) {
        this.path = path;
    }

    /**
     * read from properties to Map<String, Set<String>>
     */
    public Map<String, Set<String>> loadMails() throws WrongFormatEmailsException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String space = " ";
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                String[] strs = s.split(" ->", 2);
                if (strs[1].isEmpty()) {
                    throw new IllegalArgumentException();
                }
                String[] mails = strs[1].split(",");
                 direct.put(strs[0], new HashSet<>());
                for (String s1 : mails) {
                   direct.get(strs[0]).add(s1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return direct;
    }

    /**
     * union users by common emails
     */
    public Map<String, Set<String>> union(Map<String, Set<String>> mails) {
        Map<String, Set<String>> dir = new HashMap<>();
        for (Map.Entry<String, Set<String>> user : mails.entrySet()) {
            findUser = "";
            for (Map.Entry<String, Set<String>> map : dir.entrySet()) {
                if (map.getValue().size() > 0 && !Collections.disjoint(user.getValue(), map.getValue())) {
                    if (findUser.equals("")) {
                        findUser = map.getKey();
                        dir.get(map.getKey()).addAll(user.getValue());
                    } else {
                        dir.get(findUser).addAll(map.getValue());
                        map.getValue().clear();
                    }
                }
            }
            if (findUser.equals("")) {
                dir.put(user.getKey(), user.getValue());
            }
        }
        return dir;
    }

    /**
     * output result Map to console
     */
    public void toString(Map<String, Set<String>> mapp) {
        for (Map.Entry<String, Set<String>> map : mapp.entrySet()) {
            if (map.getValue().size() > 0) {
                StringBuilder sb = new StringBuilder(map.getKey() + " ");
                String comma = "";
                for (String s : map.getValue()) {
                    sb.append(comma);
                    comma = ",";
                    sb.append(s);
                }
                System.out.println(sb);
            }
        }
    }

    public static void main(String[] args) throws WrongFormatEmailsException {
        String path = "src/data/emails.properties";
//        String path = "src/data/emails_hard.properties";
//        String path = "src/data/emailTwo.properties";
        EmailVer21 em = new EmailVer21(path);
        var print = em.loadMails();
        em.toString(em.union(em.direct));
    }
}
