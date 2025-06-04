package ru.job4j.tasks.string;

public class LogLine {
    public record Line(String level, String threads, String text) { }

    public Line parse(String text) {
        int firstSpace = text.indexOf(" ");
        int lastBracket = getLastThreadBracket(text);

        return new Line(text.substring(0, firstSpace),
                text.substring(firstSpace + 1, lastBracket + 1),
                text.substring(lastBracket + 2));
    }

    public static int getLastThreadBracket(String text) {
        char[] chars = text.toCharArray();
        int openBrackets = 0;
        int closeBrackets = 0;
        int i = 0;

        for (char c : chars) {
            if (c == '[') {
                openBrackets++;
            }

            if (c == ']') {
                closeBrackets++;
            }

            if (openBrackets == closeBrackets && openBrackets != 0) {
                return i;
            }
            i++;
        }
        return i;
    }
}
