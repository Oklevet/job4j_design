package ru.job4j.tasks.loop;

public class Task116 {
    public static void loop(int num) {
        int sum = 0;
        int count = 0;
        for (char ch : String.valueOf(num).toCharArray()) {
            sum += Integer.parseInt(String.valueOf(ch));
            count++;
        }
        System.out.println("Количество: " + count + ", сумма: " + sum);
    }
}