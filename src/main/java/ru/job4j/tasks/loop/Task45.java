package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task45 {
    public static void loop(int num) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 100; i < 500; i++) {
            if ((i - num) % 100 == 0) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static void main(String[] args) {
        loop(23);
    }
}
