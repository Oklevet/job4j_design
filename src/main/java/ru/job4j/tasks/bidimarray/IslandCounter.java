package ru.job4j.tasks.bidimarray;

import java.util.*;

public class IslandCounter {

    static Map<String, Integer> checkedCoordinates = new HashMap<>();
    static Map<Integer, Integer> islands = new HashMap<>();

    public int findLargestIsland(int[][] map) {
        int cntIslands = 0;
        checkedCoordinates.clear();
        islands.clear();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                String coordKey = String.format("%02d", i) + String.format("%02d", j);
                if (map[i][j] == 1) {
                    if (checkedCoordinates.containsKey(coordKey)) {
                        continue;
                    }

                    checkedCoordinates.put(coordKey, 0);
                    cntIslands++;
                    islands.put(cntIslands, 1);
                    exploreIslandCrossCells(map, i, j, cntIslands);
                } else {
                    checkedCoordinates.put(coordKey, 0);
                }
            }
        }

        return getMaxCountIsland();
    }

    public static int getMaxCountIsland() {
        if (islands.size() == 0) {
            return 0;
        }
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : islands.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getValue();
    }

    public static void exploreIslandCrossCells(int[][] map, int a, int b, int islandNum) {
        if (b > 0) {
            if (checkIslandInCell(map, a, b - 1)) {
                islands.computeIfPresent(islandNum, (k, v) -> v + 1);
                exploreIslandCrossCells(map, a, b - 1, islandNum);
            }
        }
        if (a > 0) {
            if (checkIslandInCell(map, a - 1, b)) {
                islands.computeIfPresent(islandNum, (k, v) -> v + 1);
                exploreIslandCrossCells(map, a - 1, b, islandNum);
            }
        }
        if (a < map[0].length - 1) {
            if (checkIslandInCell(map, a + 1, b)) {
                islands.computeIfPresent(islandNum, (k, v) -> v + 1);
                exploreIslandCrossCells(map, a + 1, b, islandNum);
            }
        }
        if (b < map.length - 1) {
            if (checkIslandInCell(map, a, b + 1)) {
                islands.computeIfPresent(islandNum, (k, v) -> v + 1);
                exploreIslandCrossCells(map, a, b + 1, islandNum);
            }
        }
    }

    public static boolean checkIslandInCell(int[][] map, int a, int b) {
        String coordKey = String.format("%02d", a) + String.format("%02d", b);

        if (map.length <= a || map[0].length <= b) {
            return false;
        }
        if (checkedCoordinates.containsKey(coordKey)) {
            return false;
        }
        checkedCoordinates.put(coordKey, 0);
        return map[a][b] == 1;
    }
}