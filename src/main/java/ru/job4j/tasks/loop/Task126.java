package ru.job4j.tasks.loop;

import java.util.LinkedList;
import java.util.List;

public class Task126 {
    public static void loop(int num) {
        List<String> listOdd = new LinkedList<>();
        List<String> listEven = new LinkedList<>();
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                listEven.add(String.valueOf(chars[i]));
            } else {
                listOdd.add(String.valueOf(chars[i]));
            }
        }

        if (listOdd.size() > 0) {
            System.out.println(String.join(" ", listOdd));
        }

        if (listEven.size() > 0) {
            System.out.println(String.join(" ", listEven));
        }
    }
}