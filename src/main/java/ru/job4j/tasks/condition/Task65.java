package ru.job4j.tasks.condition;

public class Task65 {
    public static void season(int number) {
        String res = null;
        if ((number < 3 && number >0) || number == 12) {
            res = "Зима";
        }

        if (number > 2 && number < 6) {
            res = "Весна";
        }

        if (number > 5 && number < 9) {
            res = "Лето";
        }

        if (number > 8 && number < 12) {
            res = "Осень";
        }

        if (res == null) {
            res = "Не является месяцем";
        }
        System.out.println(res);
    }
}
