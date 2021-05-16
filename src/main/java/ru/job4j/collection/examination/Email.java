package ru.job4j.collection.examination;

import java.util.*;

public class Email {
    List<Record> emails = new ArrayList<>();

    public Email(String path) throws WrongFormatEmailsException {
        this.emails = new GetProperty(path).loadMails();
    }

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
        String path = "src/data/empty.properties";
        Email email = new Email(path);
        Email.union(email.emails);
        System.out.println(email.toString());
    }
}
