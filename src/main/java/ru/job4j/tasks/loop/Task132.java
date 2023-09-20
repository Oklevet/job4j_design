package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task132 {
    public static void loop(int[] nums) {
        StringJoiner sj = new StringJoiner(" ");
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] % 2 == 0 && i % 2 != 0) {
                count++;
                if (count == 3) {
                    break;
                }
            }
            sj.add(String.valueOf(nums[i - 1]));
        }
        System.out.println(sj);
    }
}