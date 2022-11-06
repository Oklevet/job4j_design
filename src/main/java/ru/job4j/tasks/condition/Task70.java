package ru.job4j.tasks.condition;

public class Task70 {
    public static void secondsToMinutes(int seconds) {
        String res;
        res = "Минут: " + seconds / 60 + ", секунд: " + seconds % 60;

        if (seconds >= 3600) {
            res = "Расчет не производится";
        }
        System.out.println(res);
    }
}
