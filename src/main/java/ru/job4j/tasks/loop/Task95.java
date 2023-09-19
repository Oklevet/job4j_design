package ru.job4j.tasks.loop;

public class Task95 {
    public static void loop(int[] math, int[] info) {
        int maths = 0, infos = 0;
        for (int i = 0; i < math.length; i++) {
            if (math[i] + info[i] > 13) {
                if (math[i] > info[i]) {
                    maths++;
                } else {
                    infos++;
                }
            }
        }
        int sum = maths + infos;
        System.out.println("Зачислено: " + sum + ", ФМ: " + maths + ", ФИ: " + infos);
    }
}