package ru.job4j.collection.examination.ver2;

import ru.job4j.collection.examination.WrongFormatEmailsException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class EmailVer2 {
    Map<String, Set<String>> dir = new HashMap<>();
    String findUser = "",
            key;

    public EmailVer2() {
    }

    public Map<String, Set<String>> sortMail(String path) throws WrongFormatEmailsException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                String[] strs = s.split(" ->", 2);      //str[0] - user
                key = strs[0];
                if (strs[1].isEmpty()) {
                    throw new IllegalArgumentException();
                }
                Set<String> set = new HashSet<>();            //str[1] = set = emails
                Arrays.asList(strs[1].split(",")).forEach(ss -> set.add(ss));
                findUser = "";
                for (Map.Entry<String, Set<String>> map : dir.entrySet()) {
                    if (map.getValue().size() > 0 && !Collections.disjoint(set, map.getValue())) {
                        if (findUser.equals("")) {
                            findUser = map.getKey();
                            dir.get(map.getKey()).addAll(set);
                        } else {
                            dir.get(findUser).addAll(map.getValue());
                            map.getValue().clear();
                        }
                    }
                }
                if (findUser.equals("")) {
                    dir.put(key, set);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dir;
    }

    public void toString(Map<String, Set<String>> mapp) {
        for (Map.Entry<String, Set<String>> map : mapp.entrySet()) {
            System.out.print(map.getKey() + " ");
            for (String s : map.getValue()) {
                System.out.print(s + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws WrongFormatEmailsException {
        String path = "src/data/emails.properties";
//        String path = "src/data/emails_hard.properties";
//        String path = "src/data/emailTwo.properties";
        EmailVer2 em = new EmailVer2();
        var print = em.sortMail(path);
        em.toString(print);
    }
}
