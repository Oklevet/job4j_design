package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task153 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(System.lineSeparator());

        int nBull = 0;
        String line = "";

        while (nBull * 10 <= 100) {
            line = "Быков: " + nBull + ", коров: " + ((100 - nBull * 10) / 5);
            nBull++;
            sj.add(line);
        }
        System.out.println(sj);
    }
}