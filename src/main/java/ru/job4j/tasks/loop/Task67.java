package ru.job4j.tasks.loop;


public class Task67 {
    public static void loop(int num) {
        int count = 0;
        if (num > 2) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    count++;
                }
            }
        }
        if (num == 1) {
            count = -1;
        }
        System.out.println(count == 0 ? "Да" : "Нет");
    }
}