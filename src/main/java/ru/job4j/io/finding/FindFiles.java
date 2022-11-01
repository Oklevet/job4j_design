package ru.job4j.io.finding;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.Predicate;

public class FindFiles extends SimpleFileVisitor<Path> {
    private final ArgFindFiles argFindFiles;

    public FindFiles(String[] args) {
        argFindFiles = new ArgFindFiles(args);
    }

    private void getFiles() throws IOException {
        Path pathFile = Paths.get(argFindFiles.getDirectory());
        Predicate predicate = PredicateArg.newPredicate(argFindFiles.getMask(),
                argFindFiles.getN(), argFindFiles.getDirectory());
        FileVisit fileVisit = new FileVisit(predicate, argFindFiles.getN());

        try {
            Files.walkFileTree(pathFile, fileVisit);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Path> list = fileVisit.getList();
        writeLog(list, argFindFiles.getLog(), argFindFiles.getDirectory(), argFindFiles.getN());
    }

    private static void writeLog(List<Path> list, String log, String direct, String fName) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(log, true))) {
            out.write(String.format("-d %s -n %s -m -o $s", direct, fName, log));
            for (Path s : list) {
                out.write(String.valueOf(s));
                out.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при записи в файл логгирования");
        }
        list.forEach(System.out::println);
    }

    /**
     *
     * @param args-jar target/findFiles.jar -d=c/:Test -n=Names.txt -o=log.txt
     * @param args-jar target/findFiles.jar
     */
     public static void main(String[] args) throws IOException {
        new FindFiles(args).getFiles();
    }
}
