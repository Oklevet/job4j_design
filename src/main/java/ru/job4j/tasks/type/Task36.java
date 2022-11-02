package ru.job4j.tasks.type;

public class Task36 {
    public static void firstLastChange(int number) {
        int first, middle, last;
        first = number / 1000;
        middle = number / 10 % 100 * 10;
        last = number % 10 * 1000;
        System.out.println(first + middle + last);
    }
}
