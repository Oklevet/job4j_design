package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task43 {
    public static void loop() {
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 300; i < 325; i++) {
            if (check(i)) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj);
    }

    public static boolean check(int n) {
        int num;
        num = n % 100;
        if (num < 10) {
            return false;
        }
        return num % (n / 100) == 0;
    }

    public static void main(String[] args) {
        loop();
    }
}
