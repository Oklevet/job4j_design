package ru.job4j.tasks.loop;

public class Task129 {
    public static void loop(int num) {
        System.out.println(getSumDigit(num));
    }

    public static int getSumDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}