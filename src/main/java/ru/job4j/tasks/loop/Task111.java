package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task111 {
    public static void loop(int num) {
        int sum = 0;
        int pow = num * num;
        StringJoiner sj = new StringJoiner(" ");
        num++;
        while (pow > sum) {
            if (sum + num >= pow) {
                break;
            }
            sum += num;
            sj.add(String.valueOf(num));
            num++;
        }
        System.out.println(sj);
    }
}