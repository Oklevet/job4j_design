package ru.job4j.tasks.condition;

public class Task81 {
    public static void isLatin(char s) {
        if ((s > 64 && s < 91) || (s > 96 && s < 123)) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
