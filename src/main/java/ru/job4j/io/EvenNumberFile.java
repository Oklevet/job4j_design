package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder num = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                if (read == 13) {
                    System.out.println(num + " is "
                            + (Integer.parseInt(String.valueOf(num)) % 2 == 0 ? " EVEN" : "ODD"));
                } else if (read == 10) {
                    num.setLength(0);
                } else {
                    num.append((char) read);
                }
            }
            System.out.println(num + " is "
                            + (Integer.parseInt(String.valueOf(num)) % 2 == 0 ? " EVEN" : "ODD"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
