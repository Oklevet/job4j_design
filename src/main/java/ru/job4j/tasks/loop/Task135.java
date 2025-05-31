package ru.job4j.tasks.loop;

public class Task135 {
    public static void loop(int num) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0 ; i--) {
            sb.append(s.charAt(i));
        }
        sb = validateZero(String.valueOf(sb));
        System.out.println(sb);
    }

    public static StringBuilder validateZero(String num) {
        StringBuilder sb = new StringBuilder();
        boolean checkStartFrom0 = true;

        for (int i = 0; i < num.length(); i++) {
            if (!checkStartFrom0) {
                sb.append(num.charAt(i));
                continue;
            }
            if (num.charAt(i) != '0') {
                sb.append(num.charAt(i));
                checkStartFrom0 = false;
            }
        }
        return sb;
    }
}
