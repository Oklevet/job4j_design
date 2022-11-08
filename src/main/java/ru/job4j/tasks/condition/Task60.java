package ru.job4j.tasks.condition;

public class Task60 {
    public static void numRelation(int a, int b, int c) {
        String res;

        if (a > b) {
            if (b == c) {
                res = "Второе и третье равны, первое больше";
            } else {
                res = "Первое и третье равны, второе меньше";
            }
        } else if (a < b) {
            if (b == c) {
                res = "Второе и третье равны, первое меньше";
            } else {
                res = "Первое и третье равны, второе больше";
            }
        } else {
            if (b > c) {
                res = "Первое и второе равны, третье меньше";
            } else {
                res = "Первое и второе равны, третье больше";
            }
        }

        if (a == b && a == c) {
            res = "Все равны";
        }

        if (a != b && a != c && b != c) {
            res = "Равных нет";
        }
        System.out.println(res);
    }
}
