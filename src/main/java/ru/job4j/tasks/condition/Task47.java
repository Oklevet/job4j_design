package ru.job4j.tasks.condition;

public class Task47 {
    public static void changeNum(int number) {
        int num1, num2, num3;
        num1 = number / 100;
        num2 = number / 10 % 10;
        num3 = number % 10;
        if (number > 500) {
            System.out.println(num1 + num2 * 10 + num3 * 100);
        } else {
            System.out.println(num1 * 100 + num3 * 10 + num2);
        }
    }
}
