package ru.job4j.tasks.map;

import java.util.*;

public class UrlPatternGrouper {
    Map<String, Integer> map = new HashMap<>();

    public static class PageStatistic {
        private final String pattern;
        private final int count;

        public PageStatistic(String pattern, int count) {
            this.pattern = pattern;
            this.count = count;
        }

        public String getPattern() {
            return pattern;
        }

        public int getCount() {
            return count;
        }
    }

    public void add2Map(String str) {
        map.computeIfPresent(str, (k, v) -> v + 1);
        map.putIfAbsent(str, 1);
    }

    public List<PageStatistic> groupUrls(List<String> urls) {
        List<PageStatistic> list = new ArrayList<>();
        map.clear();

        for (String s : urls) {
            int secSlash = s.indexOf("/", 1);

            if (secSlash > 1) {
                String key = s.substring(0, secSlash);
                if (s.length() > secSlash) {
                    add2Map(key + "/..");
                }
            } else {
                add2Map(s);
            }
        }
        map.forEach((key, value) -> list.add(new PageStatistic(key, value)));
        return list;
    }
}