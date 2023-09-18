package ru.job4j.tasks.loop;

public class Task72 {
    public static void loop(int num) {
        int sum = 0;
        for (int i = num - 1; i > 0; i--) {
            sum += i;
        }
        System.out.println(sum);
    }
}