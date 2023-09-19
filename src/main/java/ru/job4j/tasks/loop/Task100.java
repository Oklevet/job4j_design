package ru.job4j.tasks.loop;

public class Task100 {
    public static void loop(int[] num) {
        int max = 0;
        int sum = 0;
        for (int n : num) {
            if (n / 10 + n % 10 > sum) {
                sum = n / 10 + n % 10;
                max = n;
            }
        }
        System.out.println(max);
    }
}