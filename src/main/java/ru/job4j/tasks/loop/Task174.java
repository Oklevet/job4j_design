package ru.job4j.tasks.loop;

public class Task174 {
    public static void isPalindrome(int number) {
        int reverted = 0;
        double fullLen = String.valueOf(number).length();
        int len = (int) fullLen / 2;
        int num = number % (int) (Math.pow(10, len));

        if (len > 2) {
            for (int i = 1; i < len / 2; i++) {
                reverted += num % Math.pow(10, i);
                reverted += num / Math.pow(10, len - i);
            }
        } else if (len == 2) {
            reverted = num / 10 + (num % 10 * 10);
        } else if (len == 1) {
            reverted = number % 10;
        }

        if (fullLen == 1) {
            System.out.println("Да");
        } else {
            System.out.println(number / (int) (Math.pow(10, Math.ceil(fullLen / 2))) == reverted ? "Да" : "Нет");
        }
    }

}
