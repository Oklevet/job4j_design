package ru.job4j.tasks.loop;

import java.util.StringJoiner;

public class Task141 {
    public static void loop(int x, int y) {
        StringJoiner sj = new StringJoiner(" ");
        int nx = Math.max(x, y);
        int nn = Math.min(x, y);
        int cnt = 0;

        while (nx > nn) {
            if (nx % 2 == 0) {
                nx = nx / 2;
            } else {
                nx--;
            }
            if (nx == nn) {
                if (cnt == 0) {
                    sj.add(String.valueOf(0));
                }
                break;
            }
            sj.add(String.valueOf(nx));
            cnt++;
        }
        System.out.println("Числа: " + sj + ", Количество: " + cnt);
    }
}
