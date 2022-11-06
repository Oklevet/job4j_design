package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task20 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        System.out.println("Начало");

        for (int i = 1549; i > 1049; i--) {
            if (i % 100 == 0) {
                sj.add(String.valueOf(i));
            }
        }

        System.out.println(sj);
        System.out.println("Конец");
    }
}
