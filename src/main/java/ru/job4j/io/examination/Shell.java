package ru.job4j.io.examination;

import java.util.Arrays;
import java.util.Stack;

public class Shell {
    Stack<String> curr = new Stack<>();

    public void cd(String path) {
        if (path.startsWith("/")) {
            if (path.length() != 1) {
                curr.clear();
                writeToStack(curr, path);
            }
            return;
        }

        if (path.equals("..")) {
            curr.clear();
            return;
        }
        boolean pathStSpots = path.charAt(0) == '.'
                && path.charAt(1) == '.';
        if (!pathStSpots) {
            curr.push(path);
        } else {
            while (path.startsWith("..")) {
                path = path.substring(3);
                curr.pop();
            }
            writeToStack(curr, path);
        }
    }

    public String pwd() {
        if (curr.size() == 0) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        curr.forEach(c -> sb.append("/").append(c));
        return String.valueOf(sb);
    }

    public static void writeToStack(Stack<String> curr, String path) {
        String[] s = path.split("/");
        Arrays.stream(s)
                .filter(str -> !(str.isEmpty()))
                .forEach(curr::push);
    }
}
