package ru.job4j.tasks.type;

public class Task43 {
    public static void rightNumChange(int number1, int number2) {
        int num1, num2, numb1, numb2;
        num1 = number1 % 10;
        num2 = number2 % 10;
        System.out.println(number1 - num1 + num2);
        System.out.println(number2 - num2 + num1);
    }
}

