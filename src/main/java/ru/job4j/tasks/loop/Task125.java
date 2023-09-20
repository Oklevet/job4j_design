package ru.job4j.tasks.loop;

import java.util.LinkedList;
import java.util.List;

public class Task125 {
    public static void loop(int num) {
        List<String> listOdd = new LinkedList<>();
        List<String> listEven = new LinkedList<>();
        int digit;
        while (num > 0) {
            digit = num % 10;
            num /= 10;
            if (digit % 2 == 0) {
                listEven.add(0, String.valueOf(digit));
            } else {
                listOdd.add(0, String.valueOf(digit));
            }
        }

        if (listEven.size() > 0) {
            System.out.println(String.join(" ", listEven));
        }

        if (listOdd.size() > 0) {
            System.out.println(String.join(" ", listOdd));
        }
    }
}