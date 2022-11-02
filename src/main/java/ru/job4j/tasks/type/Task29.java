package ru.job4j.tasks.type;

public class Task29 {
    public static void numSum(int number) {
        int num1, num2, num3;
        num1 = number / 100;
        num2 = number / 10 % 10;
        num3 = number % 10;
        System.out.println(num1 + num2 + num3);
    }
}
