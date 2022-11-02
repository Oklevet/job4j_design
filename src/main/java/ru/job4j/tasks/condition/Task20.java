package ru.job4j.tasks.condition;

public class Task20 {
    public static void sumOrMultiply(int number1, int number2) {
        if (number1 > number2) {
            System.out.println(number1 + number2);
        } else if (number1 == number2) {
            System.out.println("Числа равны");
        } else {
            System.out.println(number1 * number2);
        }
    }
}
