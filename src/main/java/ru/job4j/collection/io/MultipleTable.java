package ru.job4j.collection.io;

import java.io.FileOutputStream;

public class MultipleTable {
    public static void main(String[] args) {
        String s = "";
        try (FileOutputStream out = new FileOutputStream("multipleTable.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    s = s + i * j + " ";
                }
                s += System.lineSeparator();
                out.write(s.getBytes());
                s = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
