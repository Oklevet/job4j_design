package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task40 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 20; i < 40; i++) {
            if (checkDivThree(i)) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static boolean checkDivThree(int n) {
        return n % 10 % 3 == 0 && n / 10 % 3 == 0;
    }

    public static void main(String[] args) {
        loop();
    }
}
