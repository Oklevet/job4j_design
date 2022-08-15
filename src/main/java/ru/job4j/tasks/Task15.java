package ru.job4j.tasks;

import java.util.StringJoiner;

public class Task15 {
    public static void main(String[] args) {
        String source = "+!?";
        String strPlus = source.substring(0, 1);
        String strExclam = source.substring(1, 2);
        String strQuast = source.substring(2, 3);
        String res = new StringJoiner("").add(strPlus).add(strPlus).add(strPlus).toString();
        System.out.println(res);
        res = new StringJoiner("").add(strExclam).add(strExclam).add(strExclam).add(strExclam).toString();
        System.out.println(res);
        res = new StringJoiner("").add(strQuast).add(strQuast).toString().toString();
        System.out.print(res);
    }
}
