package ru.job4j.tasks.condition;

public class Task73 {
    public static void midDigitLess(int num) {
        int num1, num2, num3;
        num1 = num / 100;
        num2 = num / 10 % 10;
        num3 = num % 10;
        if (num2 < num1 && num2 < num3) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}