package ru.job4j.tasks.loop;

public class Task103 {
    public static void loop(int[] num) {
        int min = 0;
        int sum = 30;
        for (int n : num) {
            int calc = n / 100 + n / 10 % 10 + n % 10;
            if (calc < sum) {
                sum = calc;
                min = n;
            }
        }
        System.out.println(min);
    }
}