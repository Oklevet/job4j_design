package ru.job4j.tasks.loop;

public class Task119 {
    public static void loop(int num, int digit) {
        boolean yes = false;
        for (char ch : String.valueOf(num).toCharArray()) {
            if (digit == Integer.parseInt(String.valueOf(ch))) {
                yes = true;
            }
        }
        System.out.println(yes ? "Да" : "Нет");
    }
}
