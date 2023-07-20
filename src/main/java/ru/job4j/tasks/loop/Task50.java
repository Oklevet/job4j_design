package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task50 {
    public static void loop(int n) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 1; i <= 5 * n; i += n) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
    }

    public static void main(String[] args) {
        loop(3);
    }
}
