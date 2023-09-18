package ru.job4j.tasks.loop;

public class Task70 {
    public static void loop(int x, int y, int r, int[] coords) {
        int in = 0;
        int on = 0;
        for (int i = 0; i < coords.length - 1; i += 2) {
            double multi = Math.pow(x - coords[i], 2) + Math.pow(y - coords[i + 1], 2);
            double radius = Math.pow(r, 2);
            if (multi == radius) {
                on++;
            }

            if (multi < radius) {
                in++;
            }
        }
        System.out.println("На окружности: " + on + ", внутри: " + in);
    }
}