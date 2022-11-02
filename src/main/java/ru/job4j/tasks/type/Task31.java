package ru.job4j.tasks.type;

public class Task31 {
    public static void difference(int number) {
        int num1, num2, num3;
        num1 = number / 100;
        num2 = number / 10 % 10;
        num3 = number % 10;
        System.out.println(Math.abs(num1 - num3) * num2);
    }
}
