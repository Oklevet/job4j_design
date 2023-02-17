package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) throws IOException {
        try {
            Path dir = Paths.get("path/paths");
            Files.createDirectories(dir);
            Path path = Path.of("path/paths/path.txt");
            Files.createFile(path);
        } catch (Exception ignored) { }

        Path path = Path.of("path/paths/path.txt");
        Path dir = Paths.get("path/paths");
        File file = path.toFile();
        System.out.println(file);
        Path pathAgain = file.toPath();
        System.out.println(pathAgain);
        System.out.println("Файл/директория существует?: " + Files.exists(path));
        System.out.println("Это директория?: " + Files.isDirectory(path));
        System.out.println("Это файл?: " + Files.isRegularFile(path));
        System.out.println("Имя файла: " + path.getFileName());
        System.out.println("Путь к файлу абсолютный?: " + path.isAbsolute());
        System.out.println("Родительская директория файла: " + path.getParent());
        System.out.println("Абсолютный путь к файлу: " + path.toAbsolutePath());
        System.out.println("Абсолютный путь к директории: " + dir.toAbsolutePath());
        System.out.println("Доступен для чтения?: " + Files.isReadable(path));
        System.out.println("Доступен для записи?: " + Files.isWritable(path));

        dir = Paths.get("path/paths");
        path = Path.of("path/paths/path.txt");
        try {
            Files.move(path, Path.of("path/path.txt"));
        } catch (Exception ignored) { }

        try {
            Files.delete(dir);
        } catch (Exception ignored) { }

        dir = Paths.get("path/paths");
        Files.createDirectories(dir);
        Path target = Paths.get("path");
        Path path1 = Path.of("path/paths/path1.txt");
        Files.createFile(path1);
        Path path2 = Path.of("path/path2.txt");
        Files.createFile(path2);
        DirectoryStream<Path> paths = Files.newDirectoryStream(target);
        paths.forEach(System.out::println);
    }
}
