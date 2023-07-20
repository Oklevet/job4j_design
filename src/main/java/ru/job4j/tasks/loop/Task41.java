package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task41 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 20; i < 36; i++) {
            if (checkDivThreeWithSameRemain(i)) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static boolean checkDivThreeWithSameRemain(int n) {
        return n % 10 % 3 == n / 10 % 3;
    }

    public static void main(String[] args) {
        loop();
    }
}
