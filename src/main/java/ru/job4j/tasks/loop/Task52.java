package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task52 {
    public static void loop(int n, int m) {
        int start = n < m ? m : n;
        int count = n < m ? n : m;
        StringJoiner sj = new StringJoiner(" ");

        for (int i = start; i < start + count; i++) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj);
    }

    public static void main(String[] args) {
        loop(5, 3);
    }
}
