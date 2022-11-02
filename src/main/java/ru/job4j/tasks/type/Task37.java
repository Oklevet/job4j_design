package ru.job4j.tasks.type;

public class Task37 {
    public static void leftShift(int number) {
        int num1, num2;
        num1 = number / 10 % 10 * 100;
        num2 = number % 10 * 10;
        System.out.println(num1 + num2);
    }
}
