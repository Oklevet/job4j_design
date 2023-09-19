package ru.job4j.tasks.loop;

public class Task83 {
    public static void loop(int num) {
        double a, sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += Math.sqrt(2 * i - 1);
        }
        System.out.printf("%.2f", sum);
    }
}