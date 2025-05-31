package ru.job4j.tasks.loop;

public class Task139 {
    public static void loop(int num) {
        int res = 1;
        for (int i = 2; i < num + 1; i++) {
            if (num % i == 0) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}