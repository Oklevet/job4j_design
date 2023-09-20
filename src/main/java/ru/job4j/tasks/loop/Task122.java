package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task122 {
    public static void loop(int[] nums) {
        StringJoiner sj = new StringJoiner(" ");
        for (int num : nums) {
            int sum = 0;
            int n = num;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if (sum == 5) {
                break;
            }
            sj.add(String.valueOf(num));
        }
        System.out.println(sj);
    }
}