package ru.job4j.tasks.condition;

import java.util.Arrays;

public class Task49 {
    public static void isPalindrome(int number) {
        boolean res = true;
        String str = String.valueOf(number);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                res = false;
                break;
            }
        }
        System.out.println(res ? "Да" : "Нет");
    }
}
