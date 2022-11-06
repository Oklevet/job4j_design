package ru.job4j.tasks.condition;

public class Task83 {
    public static void isEquals(String name1, String surname1, String name2, String surname2) {
        String res = null;
        if (name1.equals(name2)) {
            res = "Тезки";
            if (surname1.equals(surname2)) {
                res = "Тезки и однофамильцы";
            }
        }

        if (res == null) {
            if (surname1.equals(surname2)) {
                res = "Однофамильцы";
            } else {
                res = ("Совпадений нет");
            }
        }
        System.out.println(res);
    }
}
