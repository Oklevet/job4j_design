package ru.job4j.tasks.condition;

public class Task53 {
    public static void transform(int number) {
        String str = String.valueOf(number);
        StringBuilder sb = new StringBuilder();
        int vTemp;

        if (str.charAt(0) == '-') {
            str = str.substring(1);
            sb.append("-");
        }

        for (int i = 0; i < str.length(); i++) {
            vTemp = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (number % 2 == 0) {
                if (vTemp % 2 == 0 && vTemp >= 0 && vTemp < 9) {
                    sb.append(++vTemp);
                } else if (vTemp % 2 != 0 && vTemp > 1 && vTemp < 10) {
                    sb.append(--vTemp);
                } else {
                    sb.append(vTemp);
                }
            } else {
                if (vTemp % 2 == 0 && vTemp > 1 && vTemp < 10) {
                    sb.append(--vTemp);
                } else if (vTemp % 2 != 0 && vTemp >= 0 && vTemp < 9) {
                    sb.append(++vTemp);
                } else {
                    sb.append(vTemp);
                }
            }
        }
        System.out.println(sb);
    }
}
