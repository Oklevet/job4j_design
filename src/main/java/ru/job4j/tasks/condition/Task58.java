package ru.job4j.tasks.condition;

public class Task58 {
    public static void isWinning(int number) {
        int num1, num2, num3, num4, num5, num6;
        num1 = number / 100000;
        num2 = number / 10000 % 10;
        num3 = number / 1000 % 10;
        num4 = number / 100 % 10;
        num5 = number / 10 % 10;
        num6 = number % 10;
        num1 = num1 + num2 + num3;
        num4 = num4 + num5 + num6;
        if (num1 == num4 && num1 % 2 == 0) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
