package ru.job4j.tasks.type;

public class Task35 {
    public static void firstLastChange(int number) {
        int num1, num2, num3;
        num1 = number / 100;
        num2 = number / 10 % 10 * 10;
        num3 = number % 10 * 100;
        System.out.println(num1 + num2 + num3);
    }
}
