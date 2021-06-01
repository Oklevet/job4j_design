package ru.job4j.io.finding;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PredicateArg {

    public static Predicate newPredicate(String arg, String fileFind, String direct) {
        return new Predicate<Path>() {
            @Override
            public boolean test(Path path) {
                boolean rsl = false;
                switch (arg) {
                    case "-f" -> rsl = path.toFile().getName().equals(fileFind);
                    case "-m" -> rsl = path.toFile().getName().endsWith(fileFind.substring(2));
                    case "-r" -> {
                        Pattern p = Pattern.compile(fileFind);
                        Matcher m = p.matcher(direct);
                        rsl = m.matches();
                    }
                }
                return rsl;
            }
        };
    }
}
