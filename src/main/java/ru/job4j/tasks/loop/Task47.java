package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task47 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 1345; i < 1445; i++) {
            if (firstSec(i) && preLastLast(i)) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static boolean firstSec(int n) {
        return n / 1000 + n / 100 % 10 == 5;
    }

    public static boolean preLastLast(int n) {
        return n / 10 % 10 + n % 10 == 5;
    }

    public static void main(String[] args) {
        loop();
    }
}
