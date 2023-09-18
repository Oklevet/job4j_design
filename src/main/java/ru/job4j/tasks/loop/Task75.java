package ru.job4j.tasks.loop;

public class Task75 {
    public static void loop(int num) {
        int sum = 0;
        int count = 0;
        for (int i = 1; i < num + 1; i++) {
            if (num % i == 0) {
                sum += i;
                count++;
            }
        }
        System.out.println((sum % count == 0 && num % count == 0) ? "Да" : "Нет");
    }
}
