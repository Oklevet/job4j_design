package ru.job4j.tasks.loop;

public class Task142 {
    public static void loop(int num) {
        int n1 = 0;
        int n2 = 1;
        int nTemp;
        boolean res = n1 == num;

        while (n2 <= num) {

            if (n2 == num) {
                res = true;
                break;
            }

            nTemp = n1;
            n1 = n2;
            n2 = nTemp + n2;
        }

        System.out.println(res ? "Да" : "Нет");
    }
}