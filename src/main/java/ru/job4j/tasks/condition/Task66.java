package ru.job4j.tasks.condition;

public class Task66 {
    public static void daytime(int number) {
        String res = null;
        if (number < 11 && number > 5) {
            res = "Утро";
        }

        if (number > 10 && number < 18) {
            res = "День";
        }

        if (number > 17 && number < 23) {
            res = "Вечер";
        }

        if (number == 23 || number > 0 && number < 6) {
            res = "Ночь";
        }

        if (res == null) {
            res = "Не является часом";
        }
        System.out.println(res);
    }
}
