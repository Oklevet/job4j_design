package ru.job4j.tasks.condition;

public class Task74 {
    public static void innerNum(int num2, int num4) {
        String str1 = String.valueOf(num2);
        String str2 = String.valueOf(num4);
        System.out.println(str2.contains(str1) ? "Да" : "Нет");
    }
}
