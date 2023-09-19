package ru.job4j.tasks.loop;

public class Task106 {
    public static void loop(int[] nums) {
        for (int n : nums) {
            if (n == 0) {
                break;
            }
            System.out.println(n);
        }
    }
}