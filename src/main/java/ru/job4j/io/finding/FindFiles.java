package ru.job4j.io.finding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.*;

public class FindFiles extends SimpleFileVisitor<Path> {
    private List<String> result = new LinkedList<>();
    private final ArgFindFiles argFindFiles;

    public FindFiles(String[] args) {
        argFindFiles = new ArgFindFiles(args);
    }

    private void writeLog() throws IOException {
        if (argFindFiles.getValues().containsKey("-r")) {
           String regExp = "glob:**" + argFindFiles.getN();
           PathMatcher matcher = FileSystems.getDefault().getPathMatcher(regExp);
           Path directory = Path.of(argFindFiles.getDirectory());

           Files.walkFileTree(directory,
                   new FileVisit(matcher::matches, this));
        } else if (argFindFiles.getValues().containsKey("-f")) {
            String fullName = argFindFiles.getN();
            String target = Path.of(fullName).toFile().getName();
            Path directory = Path.of(argFindFiles.getDirectory());

            Files.walkFileTree(directory,
                    new FileVisit(p -> target.equals(p.toFile().getName()), this));
        } else if (argFindFiles.getValues().containsKey("-m")) {
            String s = argFindFiles.getMask();
            String[] arr = s.split("\\*");
            String ext = arr[1];
            Path directory = Path.of(argFindFiles.getDirectory());

            Files.walkFileTree(directory,
                    new FileVisit(p -> p.toString().endsWith(ext), this));
        }
        result.forEach(System.out::println);                                                        //test zone
        System.out.println(result.size());                                                          //test zone
        try (PrintWriter printWriter = new PrintWriter(argFindFiles.getLog())) {
            for (String entry: result) {
                printWriter.println(entry);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> getResult() {
        return result;
    }

    //java -jar target/findFiles.jar -d=c/:Test -n=Names.txt -o=log.txt
    //java -jar target/findFiles.jar

     public static void main(String[] args) throws IOException {
        new FindFiles(args).writeLog();
    }
}
