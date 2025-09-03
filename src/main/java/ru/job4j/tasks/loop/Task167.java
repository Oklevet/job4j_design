package ru.job4j.tasks.loop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicReference;

public class Task167 {
    public static void loop(int[] first, int[] second, int[] third) {
        StringJoiner res = new StringJoiner(System.lineSeparator());
        ArrayList<Double> avgs = new ArrayList<Double>();

        avgs.add(getAvgScore(first));
        avgs.add(getAvgScore(second));
        avgs.add(getAvgScore(third));

        res.add(getLine(first)).add(getLine(second)).add(getLine(third));

        String line4 = "Выше 4.5: " + avgs.stream().filter(x -> x > 4.5).count() + ", наивысшая: "
                + avgs.stream().max(Comparator.naturalOrder()).get();

        res.add(line4);

        System.out.println(res);
    }

    public static String getLine(int[] nums) {
        double avg = Arrays.stream(nums).average().getAsDouble();
        AtomicReference<String> scores = new AtomicReference<>("");
        Arrays.stream(nums).forEach(x -> scores.set(scores + " " + x));
        return "Оценки:" + scores.get() + ", средняя: " + avg;
    }

    public static double getAvgScore(int[] nums) {
        return Arrays.stream(nums).average().getAsDouble();
    }
}