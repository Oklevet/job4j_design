package ru.job4j.tasks;

public class Parentheses {
    public static boolean valid(char[] data) {
        int countOpen = 0;
        int countClose = 0;
        for (Character ch : data) {
            if (ch == '(' && countOpen >= countClose) {
                countOpen++;
            }
            if (ch == ')' && countOpen > countClose) {
                countClose++;
            }
        }
        return countClose == countOpen;
    }
}
