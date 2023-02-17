package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class AttributesExample {
    public static void main(String[] args) {
        Path file = Path.of("Attributes.txt");
        try {
            Files.createFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BasicFileAttributeView attrView = Files.getFileAttributeView(file, BasicFileAttributeView.class);

        try {
            BasicFileAttributes attributes = attrView.readAttributes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
