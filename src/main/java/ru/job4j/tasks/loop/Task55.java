package ru.job4j.tasks.loop;

public class Task55 {
    public static void loop(int[] array) {
        int even = 0;
        int odd = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.printf("Четных: %s, нечетных: %s", even, odd);
        System.out.println();
    }

    public static void main(String[] args) {
        loop(new int[]{-1, 1, 3});
    }
}
