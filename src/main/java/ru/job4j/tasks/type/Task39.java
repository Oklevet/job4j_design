package ru.job4j.tasks.type;

public class Task39 {
    public static void leftCircleShift(int number) {
        int num1, num2;
        num1 = number % 100 * 10;
        num2 = number / 100;
        System.out.println(num1 + num2);
    }
}
