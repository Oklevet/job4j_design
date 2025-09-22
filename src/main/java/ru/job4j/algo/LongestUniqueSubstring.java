package ru.job4j.algo;

import java.util.*;
import java.util.stream.Collectors;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        Set<Character> set = new TreeSet<>();
        Set<Character> setRes = new TreeSet<>();
        StringJoiner sj = new StringJoiner("");

        int prevSetSize = 0;
        int setSize = 0;

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
            setSize = set.size();
            if (setSize == prevSetSize) {
                if (setRes.size() < setSize) {
                    setRes = set;
                    set.clear();
                    set.add(chars[i]);
                }
            }

            prevSetSize = setSize;
        }

        if (setRes.size() == 0) {
            set.forEach(x -> sj.add(String.valueOf(x)));
        } else {
            setRes.forEach(x -> sj.add(String.valueOf(x)));
        }

        return sj.toString();
    }
}