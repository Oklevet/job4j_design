package ru.job4j.tasks.loop;

public class Task146 {
    public static void loop(int[] nums) {
        int nHuman = nums.length;
        int sumWeight = 0;
        boolean overWeight = false;
        int cntHum = 0;
        String res;

        for (int num : nums) {
            sumWeight = sumWeight + num;

            if (sumWeight > 300) {
                sumWeight = sumWeight - num;
                overWeight = true;
                break;
            }

            if (cntHum == 4) {
                sumWeight = sumWeight - num;
                break;
            }
            cntHum++;
        }
        if (nHuman > 4 && overWeight) {
            res = "Много людей и перегруз";
        } else if (nHuman > 4) {
            cntHum = 4;
            res = "Много людей";
        } else if (overWeight) {
            res = "Перегруз";
        } else {
            res = "Нет";
        }
        System.out.println("Людей: " + cntHum + ", вес: " + sumWeight + ", отказ: " + res);
    }
}
