package ru.job4j.tasks.loop;

public class Task79 {
    public static void loop(int[] grades) {
        double avg;
        int bad = 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
            if (grade < 3) {
                bad++;
            }
        }
        avg = (double) sum / grades.length;
        System.out.println("Средняя оценка: " + avg + ", неуд. оценка: " + bad);
    }
}