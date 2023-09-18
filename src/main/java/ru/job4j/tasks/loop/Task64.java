package ru.job4j.tasks.loop;

public class Task64 {
    public static void loop(int[] months) {
        int winter = 0;
        int spring = 0;
        int summer = 0;
        int fall = 0;
        for (Integer month : months) {
            if (month > 2 && month < 6) {
                spring++;
            } else {
                if (month > 5 && month < 9) {
                    summer++;
                } else {
                    if (month > 8 && month < 12) {
                        fall++;
                    } else {
                        winter++;
                    }
                }
            }
        }
        System.out.println("Зимой: " + winter + ", Весной: " + spring + ", Летом: " + summer + ", Осенью: " + fall);
    }
}