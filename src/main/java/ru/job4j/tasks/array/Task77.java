package ru.job4j.tasks.array;

public class Task77 {
    public static void array(int[] first, int[] second, int[] third) {
        int[] sums = new int[3];

        for (int i = 0; i < first.length; i++) {
            sums[i] = first[i] + second[i] + third[i];
        }

        System.out.println("Первый: " + sums[0] + ", второй: " + sums[1] + ", третий: " + sums[2]);
    }
}
