package ru.job4j.tasks.loop;

public class Task150 {
    public static void loop(int overdraft, int account, int[] transfers) {
        int cnt = 0;

        for (int i : transfers) {
            if (overdraft <= account + i) {
                account += i;
                cnt++;
            } else {
                break;
            }

            if (account == overdraft) {
                break;
            }
        }
        System.out.println("Остаток: " + account + ", операций: " + cnt);
    }
}