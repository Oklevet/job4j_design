package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task121 {
    public static void loop(int[] nums) {
        StringJoiner sj = new StringJoiner(" ");
        for (int n : nums) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            sj.add(String.valueOf(sum));
        }
        System.out.println(sj);
    }
}