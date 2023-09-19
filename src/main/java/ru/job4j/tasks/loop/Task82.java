package ru.job4j.tasks.loop;

public class Task82 {
    public static void loop(int[] promo, int[] concert) {
        int sumTicket = 0;
        int sumBonus = 0;
        for (int i : promo) {
            sumTicket += i;
            sumBonus += Math.floor((double) i / 10);
        }
        for (int i : concert) {
            sumTicket += i;
        }
        System.out.println("Продано билетов: " + sumTicket + ", выдано бесплатно: " + sumBonus);
    }
}