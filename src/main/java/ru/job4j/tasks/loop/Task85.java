package ru.job4j.tasks.loop;

public class Task85 {
    public static void loop(int money, int percent, int months) {
        double sum = money;
        for (int i = 1; i <= months; i++) {
            sum = sum * (1 + (double) percent / 100);
        }
        System.out.printf("%.2f" + System.lineSeparator(), sum);
    }
}