package ru.job4j.tasks.loop;

public class Task159 {
    public static void loop() {
        int max = 0;
        int currNum = 0;

        for (int i = 1; i < 10001; i++) {
            int sum = 0;

            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (max < sum) {
                max = sum;
                currNum = i;
            }
        }
        System.out.println(currNum);
    }
}