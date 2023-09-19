package ru.job4j.tasks.loop;

public class Task112 {
    public static void loop(int num, int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num - nums[i] <= 0) {
                break;
            }
            num -= nums[i];
            count++;
        }
        System.out.println(count);
    }
}