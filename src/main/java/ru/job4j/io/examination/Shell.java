package ru.job4j.io.examination;

import java.io.File;

public class Shell {
    String curr =  new File(System.getenv("SystemDrive")) + "/";

    public void cd(String path) {
        if (path.startsWith("/")) {
            if (path.length() == 1) {
                return;
            } else {
                curr = "//" + path;
                return;
            }
        }

        if (path.equals("..")) {
            curr = "../";
            return;
        }
        boolean pth = path.charAt(0) == '.'
                && path.charAt(1) == '.';
        if (!pth) {
                curr = curr + path + "/";
                return;
            }
        curr = path + "/";
    }

    public String pwd() {
        System.out.println(curr);
        if (curr.length() > 3 && curr.charAt(curr.length() - 1) == '/') {
            curr = curr.substring(0, curr.length() - 1);
        }
        return curr.substring(2);
    }
}
