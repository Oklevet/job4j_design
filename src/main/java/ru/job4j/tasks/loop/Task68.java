package ru.job4j.tasks.loop;

public class Task68 {
    public static void loop(int num1, int num2) {
        System.out.println(countDiv(num1) == countDiv(num2) ? "Да" : "Нет");
    }

    public static int countDiv(int num) {
        int count = 0;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }
}