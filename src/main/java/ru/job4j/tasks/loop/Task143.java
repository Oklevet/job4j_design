package ru.job4j.tasks.loop;

public class Task143 {
    public static void loop(int num1, int num2) {
        int nx = Math.max(num1, num2);
        int nn = Math.min(num1, num2);
        int res = 1;

        while (res > 0) {
            res = nx % nn;
            nx = nn;
            nn = res;
        }
        System.out.println(nx);
    }
}