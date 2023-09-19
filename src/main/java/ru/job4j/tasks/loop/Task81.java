package ru.job4j.tasks.loop;

public class Task81 {
    public static void loop(int num) {
        int max = Math.max(num / 10, num % 10);
        int min = Math.min(num / 10, num % 10);
        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}