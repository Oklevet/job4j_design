package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task39 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 200; i < 211; i++) {
            if (i % symbolsSum(i) == 0) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static int symbolsSum(int n) {
        return n / 100 + n % 10 + n / 10 % 10;
    }

    public static void main(String[] args) {
        loop();
    }
}
