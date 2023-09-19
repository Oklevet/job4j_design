package ru.job4j.tasks.loop;

public class Task84 {
    public static void loop(int a1, int a2, int num) {
        int sum = a1 + a2;
        int first = a1, second = a2, temp;
        for (int i = 1; i <= num - 2; i++) {
            temp = first;
            first = second;
            second = temp + second;
            sum += second;
        }
        System.out.println(sum);
    }
}