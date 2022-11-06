package ru.job4j.tasks.condition;

public class Task60 {
    public static void numRelation(int a, int b, int c) {
        String res;

        if (a > b) {
            if (b == c) {
                res = "Второе и третье равны, первое больше";  // a > b = c
            } else {
                res = "Первое и третье равны, второе меньше";  // a = c > b
            }
        } else if (a < b) {
            if (b == c) {
                res = "Второе и третье равны, первое меньше";  // a < b = c
            } else {
                res = "Первое и третье равны, второе больше";     // a = c < b
            }
        } else {
            if (b > c) {
                res = "Первое и второе равны, третье меньше";  // a = b > c
            } else {
                res = "Первое и второе равны, третье больше";     // a = b < c
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
