package ru.job4j.tasks.loop;

public class Task63 {
    public static void loop(int[] answers) {
        int count = 0;
        for (Integer grade : answers) {
            if (grade == 1) {
                count++;
            }
        }
        System.out.println(count + ", " + (Math.ceil(answers.length / 2) >= count ? "Нет" : "Да"));
    }
}
