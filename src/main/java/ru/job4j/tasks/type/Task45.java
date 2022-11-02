package ru.job4j.tasks.type;

public class Task45 {
    public static void leftNumChange(int number1, int number2) {
        int num1, num2;
        num1 = number1 / 100 * 100;
        num2 = number2 / 100 * 100;
        System.out.println(number1 - num1 + num2);
        System.out.println(number2 - num2 + num1);
    }
}
