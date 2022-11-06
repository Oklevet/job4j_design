package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task16 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        System.out.println("Старт");

        for (int i = 1; i < 10; i++) {
            sj.add(String.valueOf(i));
        }

        System.out.println(sj);
        System.out.println("Финиш");
    }
}
