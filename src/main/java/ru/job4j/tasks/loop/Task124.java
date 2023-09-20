package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task124 {
    public static void loop(int[] nums) {
        StringJoiner sj = new StringJoiner(" ");
        int max = -1;
        int sum;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            sum = getSumDigit(nums[i]);
            if (sum > max) {
                max = sum;
                index = i;
            }
            sj.add(String.valueOf(sum));
        }
        System.out.println("Суммы: " + sj + ", индекс: " + index);
    }

    public static int getSumDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}