package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task35 {
    public static void loop(int num) {
        int count = 0;
        StringJoiner sj = new StringJoiner(" ");
        while (count < 5) {
            num -= 6;
            sj.add(String.valueOf(num));
            count++;
        }
        System.out.println(sj);
    }
}
