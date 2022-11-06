package ru.job4j.tasks.condition;

public class Task64 {
    public static void gradePrint(int number) {
        String res;
        switch (number) {
            case (1) :
            case (2) :
                res = "Плохо";
                break;
            case (3) :
                res = "Удовлетворительно";
                break;
            case (4) :
                res = "Хорошо";
                break;
            case (5) :
                res = "Отлично";
                break;
            default:
                res = "Не соответствует";
        }
        System.out.println(res);
    }
}
