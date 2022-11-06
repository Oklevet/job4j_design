package ru.job4j.tasks.condition;

public class Task78 {
    public static void divWithoutRemainder(int num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        if (num != 0) {
            for (Character ch : str.toCharArray()) {
                if (Integer.parseInt(String.valueOf(ch)) != 0) {
                    if (num % Integer.parseInt(String.valueOf(ch)) == 0) {
                        sb.append(ch).append(" ");
                    }
                }
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
        }

        if (sb.length() == 0) {
            sb.append("Таких чисел нет");
        }
        System.out.println(sb);
    }
}
