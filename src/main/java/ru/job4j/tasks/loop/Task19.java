package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task19 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        System.out.println("Старт");

        for (int i = 107; i < 153; i += 10) {
            sj.add(String.valueOf(i));
        }

        System.out.println(sj);
        System.out.println("Финиш");
    }
}
