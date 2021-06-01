package ru.job4j.io.examination;

import java.util.Stack;

public class Shell {
    Stack<String> curr = new Stack<>();
    {
        curr.push("/");
    }

    public void cd(String path) {
        if (path.startsWith("/")) {
            if (path.length() != 1) {
                curr.pop();
                curr.push(path);
            }
            return;
        }

        if (path.equals("..")) {
            curr.pop();
            curr.pop();
            return;
        }
        boolean pth = path.charAt(0) == '.'
                && path.charAt(1) == '.';
        if (!pth) {
            curr.push(path);
            curr.push("/");
            return;
        }
        curr.pop();
        curr.push(path);
        curr.push("/");
    }

    public String pwd() {
        String c = String.valueOf(toString(curr));
        if (c.length() > 3 && c.charAt(c.length() - 1) == '/') {
            c = c.substring(0, c.length() - 1);
        }
        if (c.startsWith("..")) {
            c = c.substring(2);
        }
        return c;
    }

    public static StringBuilder toString(Stack<String> st) {
        StringBuilder sb = new StringBuilder();
        for (String s : st) {
            sb.append(s);
        }
        return sb;
    }
}
