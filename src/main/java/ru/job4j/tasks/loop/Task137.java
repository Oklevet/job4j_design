package ru.job4j.tasks.loop;

public class Task137 {
    public static void loop(int num) {
        StringBuilder sb = new StringBuilder();
        int n;

        n = calcFirstNum(num);
        n = n * 10 + calcLastNum(num - n);
        System.out.println(n);
    }

    public static int calcFirstNum(int num) {
        for (int i = 1; i < 10; i++) {
            if (num - i <= 9){
                return i;
            }
        }
        return 9;
    }

    public static int calcLastNum(int num) {
        for (int i = 0; i < 10; i++) {
            if (num == i){
                return i;
            }
        }
        return 9;
    }
}