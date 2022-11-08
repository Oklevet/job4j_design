package ru.job4j.tasks;

import java.util.ArrayList;

public class ArraysTask65 {
    public static char[] onlyLowCase(char[] input) {
        ArrayList<Character> arrayList = new ArrayList<>();
        int i = 0;

        for (Character ch : input) {
            if (Character.isLetter(ch) && Character.isLowerCase(ch)) {
                arrayList.add(Character.toUpperCase(ch));
            }
        }

        char[] resChar = new char[arrayList.size()];

        for (Character character : arrayList) {
            resChar[i] = character;
            i++;
        }

        return resChar;
    }
}
