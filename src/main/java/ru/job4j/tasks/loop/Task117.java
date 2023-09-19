package ru.job4j.tasks.loop;

public class Task117 {
    public static void loop(int num) {
        int sum = 0;
        int count = 0;
        int numb;
        for (char ch : String.valueOf(num).toCharArray()) {
            numb = Integer.parseInt(String.valueOf(ch));
            if (numb % 2 == 0) {
                sum += numb;
                count++;
            }
        }
        System.out.println("Количество: " + count + ", сумма: " + sum);
    }
}