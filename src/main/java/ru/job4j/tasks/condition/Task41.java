package ru.job4j.tasks.condition;

public class Task41 {
    public static void evenDigitsAmount(int number) {
        int vCount = 0;

        if (number / 100 % 2 == 0) {
            vCount++;
        }

         if (number / 10 % 10 % 2 == 0) {
             vCount++;
         }

         if (number % 2 == 0) {
             vCount++;
         }
        System.out.println(vCount);
    }
}
