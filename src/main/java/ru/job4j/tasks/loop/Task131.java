package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task131 {
    public static void loop(int[] nums) {
        StringJoiner sj = new StringJoiner(" ");
        int count =  0;
        for (int c : nums) {
            if (c % 2 == 0) {
                count++;
                if (count == 3) {
                    break;
                }
            }
            sj.add(String.valueOf(c));
        }
        System.out.println(sj);
    }
}