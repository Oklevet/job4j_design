package ru.job4j.tasks.type;

public class Task40 {
    public static void leftCircleShift(int number) {
        int num1, num2;
        num1 = number % 1000 * 10;
        num2 = number / 1000;
        System.out.println(num1 + num2);
    }
}
