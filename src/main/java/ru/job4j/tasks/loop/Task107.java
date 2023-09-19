package ru.job4j.tasks.loop;

public class Task107 {
    public static void loop(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (n == 999) {
                break;
            }
            System.out.println(n);
            count++;
        }
        System.out.println("Значений: " + count);
    }
}