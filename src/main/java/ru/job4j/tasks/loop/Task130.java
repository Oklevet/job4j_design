package ru.job4j.tasks.loop;

public class Task130 {
    public static void loop(int num) {
        int count =  0;
        for (char c : String.valueOf(num).toCharArray()) {
            if (c == '0') {
                count++;
            }
        }
        System.out.println(count);
    }
}