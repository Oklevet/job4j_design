package ru.job4j.tasks.loop;

public class Task62 {
    public static void loop(int amount, int[] grades) {
        int count = 0;
        for (Integer grade : grades) {
            if (grade < 3) {
                count++;
            }
        }
        System.out.println(Math.ceil(amount / 2) >= count ? "Нет" : "Да");
    }
}
