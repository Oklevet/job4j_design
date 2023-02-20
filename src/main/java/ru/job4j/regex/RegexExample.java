package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Я учусь на Job4j");

        String text1 = "Я учусь на Job4j";
        Matcher matcher1 = pattern.matcher(text1);
        boolean isPresent1 = matcher1.matches();
        System.out.println(isPresent1);

        String text2 = "Я учусь на курсе Job4j";
        Matcher matcher2 = pattern.matcher(text2);
        boolean isPresent2 = matcher2.matches();
        System.out.println(isPresent2);

        pattern = Pattern.compile("Job4j");

        text1 = "Job4j";
        matcher1 = pattern.matcher(text1);
        isPresent1 = matcher1.matches();
        System.out.println(isPresent1);

        text2 = "job4j";
        matcher2 = pattern.matcher(text2);
        isPresent2 = matcher2.matches();
        System.out.println(isPresent2);

        pattern = Pattern.compile("Job4j", Pattern.CASE_INSENSITIVE);

        text1 = "Job4j";
        matcher1 = pattern.matcher(text1);
        isPresent1 = matcher1.matches();
        System.out.println(isPresent1);

        text2 = "job4j";
        matcher2 = pattern.matcher(text2);
        isPresent2 = matcher2.matches();
        System.out.println(isPresent2);

        pattern = Pattern.compile("Job4j");
        String text = "Я учусь на курсе Job4j";
        Matcher matcher = pattern.matcher(text);
        boolean isPresent = matcher.find();
        System.out.println(isPresent);

        pattern = Pattern.compile("Job4j");
        text = "Job4j и Job4j и Job4j";
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение");
        }

        pattern = Pattern.compile("Job4j");
        text = "Job4j1 и Job4j2 и Job4j3";
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }

        pattern = Pattern.compile("Job4j");
        text = "Job4j1 и Job4j2 и Job4j3";
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение. iStart: " + matcher.start()
                    + " iEnd: " + matcher.end());
        }

        pattern = Pattern.compile("123");
        text = "1231 и 1232 и 1233";
        matcher = pattern.matcher(text);
        String rsl = matcher.replaceAll("Job4j");
        System.out.println(rsl);
    }
}