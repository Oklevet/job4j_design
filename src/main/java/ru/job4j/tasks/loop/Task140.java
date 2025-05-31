package ru.job4j.tasks.loop;

public class Task140 {
    public static void loop(int num) {
        int res = 1;
        for (int i = num / 2; i > 0; i--) {
            if (num % i == 0) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}
