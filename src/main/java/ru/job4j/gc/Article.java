package ru.job4j.gc;

import java.util.*;

public class Article {
    /**
     * split + contains
     */
    public static boolean generateBy1(String origin, String line) {
        String[] s = line.split(" ");
        for (String str : s) {
            if (!origin.contains(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sets containsAll + replace pP
     */
    public static boolean generateBy2(String origin, String line) {
        origin = replaceP(origin);
        String[] strs = origin.split(" ");
        Set<String> orig = new HashSet<>(Arrays.asList(strs));
        strs = line.split(" ");
        Set<String> lin = new HashSet<>(Arrays.asList(strs));
        return orig.containsAll(lin);
    }

    /**
     * replace pP + strings to list then
     * by cycle in lower list, try contains elements in bigger list
     */
    public static boolean generateBy3(String origin, String line) {
        origin = replaceP(origin);
        String[] strs = origin.split(" ");
        List<String> orig = new ArrayList<>(Arrays.asList(strs));
        strs = line.split(" ");
        List<String> lin = new ArrayList<>(Arrays.asList(strs));
        for (String s : lin) {
            if (!orig.contains(s)) {
                return false;
            }
        }
        return true;
    }
    /**
     * replace pP + strings to list then
     * by cycle in bigger list, try contains elements in lower list
     * then delete them. If all elements from lower list was deleted
     * method return true
     */
    public static boolean generateBy4(String origin, String line) {
        origin = replaceP(origin);
        String[] strs = origin.split(" ");
        List<String> orig = new ArrayList<>(Arrays.asList(strs));
        strs = line.split(" ");
        List<String> lin = new ArrayList<>(Arrays.asList(strs));
        for (String s : orig) {
            lin.remove(s);
        }
        return lin.size() == 0;
    }

    /**
     * delete from string punctuation marks
     */
    public static String replaceP(String s) {
        return  s.replaceAll("\\pP", "");
    }
}
