package ru.job4j.tasks;

import java.util.StringJoiner;

public class FirstTask16 {
    public static void main(String[] args) {
        String source = "+!?";
        String strPlus = source.substring(0, 1);
        String strExclam = source.substring(1, 2);
        String strQuast = source.substring(2, 3);
        String res = new StringJoiner("").add(strPlus).add(strPlus).add(strPlus).add(strExclam).add(strExclam)
                .add(strExclam).add(strExclam).add(strQuast).add(strQuast).toString();
        System.out.print(res);
    }
}
