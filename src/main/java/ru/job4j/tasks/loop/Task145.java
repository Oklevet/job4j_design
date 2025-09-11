package ru.job4j.tasks.loop;

import java.util.Locale;
import java.util.StringJoiner;

public class Task145 {
    public static void loop(int num1, double num2) {
        double current = num1;
        int cnt = 0;
        StringJoiner sj = new StringJoiner(" ");

        sj.add("Промежуточные:");

        while (Math.sqrt(current) > 1 + num2) {
            current = Math.sqrt(current);
            sj.add( String.format(Locale.ENGLISH, "%.1f", current));
            cnt++;
        }
        System.out.println(sj + ", Количество: " + cnt);
    }
}