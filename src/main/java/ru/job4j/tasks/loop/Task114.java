package ru.job4j.tasks.loop;

public class Task114 {
    public static void loop(int[] nums) {
        int prev = -1;
        int sum = 0;
        for (int n : nums) {
            if (n == prev) {
                break;
            }
            sum += n;
            prev = n;
        }
        System.out.println(sum);
    }
}