package ru.job4j.tasks.loop;

public class Task91 {
    public static void loop(int n1, int n2, int n3) {
        int max = Math.max(Math.max(n1, n2), Math.max(n1, n3));
        int min = Math.min(Math.min(n1, n2), Math.min(n1, n3));
        if ((max - min) % 2 == 0) {
            int div = (max - min) / 2;
            if (min + div == n1 || min + div == n2 || min + div == n3) {
                System.out.printf("%d %d %d" + System.lineSeparator(), (max + div), (max + 2 * div), (max + 3 * div));
            } else {
                System.out.println("Нет");
            }
        } else {
            System.out.println("Нет");
        }
    }
}