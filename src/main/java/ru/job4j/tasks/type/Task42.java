package ru.job4j.tasks.type;

public class Task42 {
    public static void rightCircleShift(int number) {
        int num1, num2;
        num1 = number / 10;
        num2 = number % 10 * 1000;
        System.out.println(num1 + num2);
    }
}
