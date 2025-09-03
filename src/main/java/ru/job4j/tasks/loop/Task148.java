package ru.job4j.tasks.loop;

public class Task148 {
    public static void loop(int children, int adults, int[] cNum, int[] aNum) {
        int saveC = children;
        int saveA = adults;
        int nGroup = 0;

        for (int i = 0; i < cNum.length; i++) {
            if (children - cNum[i] >= 0 && adults - aNum[i] >= 0) {
                children = children - cNum[i];
                adults = adults - aNum[i];
                nGroup++;
            }
        }
        System.out.println("Группы: " + nGroup + ", Взрослых: " + (saveA - adults) + ", детей: " + (saveC - children)
                + ", осталось билетов взр: " + adults + ", осталось билетов дет: " + children);
    }
}