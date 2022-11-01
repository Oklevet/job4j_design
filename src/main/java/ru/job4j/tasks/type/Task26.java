package ru.job4j.tasks.type;

public class Task26 {
    public static void transform(int number) {
        int num1, num2;
        num1 = number / 10;
        num2 = number % 10 * 10;
        System.out.println(num1 + num2 + 8);
    }
}
