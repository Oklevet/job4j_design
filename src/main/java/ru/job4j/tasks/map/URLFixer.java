package ru.job4j.tasks.map;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class URLFixer {

    public String fixQuery(String query, List<String> validParams) {
        List<String> list = List.of(query.split("&"));
        validParams = validParams.stream()
                .sorted(new Comparator<String>() {

                    @Override
                    public int compare(String o1, String o2) {
                        return o2.length() - o1.length();
                    }
                })
                .collect(Collectors.toList());
        StringJoiner sj = new StringJoiner("&");
        boolean findKey;

        for (String str : list) {
            findKey = false;
            if (str.contains("=")) {
                if (validParams.contains(str.substring(0, str.indexOf("=")))) {
                    sj.add(str);
                    continue;
                }
            }

            for (String key : validParams) {
                if (str.startsWith(key)) {
                    sj.add(key + "=" + str.substring(key.length()));
                    findKey = true;
                    break;
                }
            }
            if (!findKey) {
                sj.add(str);
            }
        }

        return String.valueOf(sj);
    }
}