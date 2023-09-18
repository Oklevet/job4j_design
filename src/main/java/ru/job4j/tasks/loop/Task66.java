package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task66 {
    public static void loop(int num) {
        int count = 0;
        StringJoiner sj = new StringJoiner(" ");
        if (num > 2) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    count++;
                    sj.add(String.valueOf(i));
                }
            }
        }
        if (count == 0) {
            sj.add("0");
        }
        System.out.println("Количество: " + count + ", Делители: " + sj);
    }
}