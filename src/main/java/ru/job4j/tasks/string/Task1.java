package ru.job4j.tasks.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    public static String maxMatch(String[] strings) {
        ArrayList<char[]> list = new ArrayList<>();
        AtomicInteger maxLen = new AtomicInteger(0);
        StringJoiner sj = new StringJoiner("");
        boolean findDiff = false;

        Arrays.stream(strings).forEach(x -> {
            maxLen.set(Math.max(x.length(), maxLen.get()));});

        for(String s : strings) {
            list.add(s.toCharArray());
        }
        for (int i = 0; i < maxLen.get(); i++) {
            char symb = '*';
            for (char[] chars : list) {
                if (chars.length == i || (symb != '*' && symb != chars[i])) {
                    findDiff = true;
                    break;
                } else {
                    symb = chars[i];
                }
            }
            if (findDiff) {
                break;
            } else {
                sj.add(String.valueOf(list.get(0)[i]));
            }
        }
        return String.valueOf(sj);
    }
}