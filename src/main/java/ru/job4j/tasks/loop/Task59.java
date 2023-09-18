package ru.job4j.tasks.loop;

public class Task59 {
    public static void loop(int num, int[] array) {
        int equal = 0;
        int lower = 0;
        for (Integer ar : array) {
            if (ar == num) {
                equal++;
            }
            if (ar < num) {
                lower++;
            }
        }
        System.out.println("Равно: " + equal + ", меньше: " + lower);
    }
}