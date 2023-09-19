package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task120 {
    public static void loop(int num) {
        String snum = String.valueOf(num);
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 1; i < snum.length(); i++) {
            sj.add(snum.substring(0, snum.length() - i));
        }
        sj.add("0");
        System.out.println(sj);
    }
}