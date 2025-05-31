package ru.job4j.tasks.loop;

public class Task138 {
    public static void loop() {
        int res = 0;
        for (int i = 10; i < 100; i++) {
            if (checkDivBySum(i)) {
                res = i;
            }
        }
        System.out.println(res);
    }
    
    public static boolean checkDivBySum(int num) {
        int sumNum;
        
        sumNum = num / 10 + num % 10;
        return num % sumNum == 0;
    }
}
