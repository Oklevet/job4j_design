package ru.job4j.tasks.biDimArray;

import java.util.HashMap;
import java.util.Map;

public class ClosedAreaCounter {
    static Map<String, Integer> checkedCoordinates = new HashMap<>();
    static Map<String, Integer> checkedZeroCoordinates = new HashMap<>();

    static boolean checkAreaCorrect;

    public int countClosedAreas(int[][] map) {
        int cntAreas = 0;
        checkedCoordinates.clear();
        checkedZeroCoordinates.clear();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                String coordKey = String.format("%02d", i) + String.format("%02d", j);
                if (map[i][j] == 0) {
                    if (checkedZeroCoordinates.containsKey(coordKey)) {
                        continue;
                    }
                    checkAreaCorrect = true;
                    checkedCoordinates.put(coordKey, 0);

                    if (exploreAreaCrossCells(map, i, j)) {
                        cntAreas++;
                    }
                    checkedCoordinates.clear();
                } else {
                    checkedCoordinates.put(coordKey, 0);
                }
            }
        }

        return cntAreas;
    }

    public static boolean exploreAreaCrossCells(int[][] map, int a, int b) {
        if (a == 0 || b == 0 || a == map[0].length - 1 || b == map[0].length - 1) {
            checkAreaCorrect = false;
        }

        if (b > 0) {
            if (checkAreaInCell(map, a, b - 1)) {
                if (!exploreAreaCrossCells(map, a, b - 1)) {
                    checkAreaCorrect = false;
                }
            }
        }
        if (a > 0) {
            if (checkAreaInCell(map, a - 1, b)) {
                if (!exploreAreaCrossCells(map, a - 1, b)) {
                    checkAreaCorrect = false;
                }
            }
        }
        if (a < map[0].length - 1) {
            if (checkAreaInCell(map, a + 1, b)) {
                if (!exploreAreaCrossCells(map, a + 1, b)) {
                    checkAreaCorrect = false;
                }
            }
        }
        if (b < map.length - 1) {
            if (checkAreaInCell(map, a, b + 1)) {
                if (!exploreAreaCrossCells(map, a, b + 1)) {
                    checkAreaCorrect = false;
                }
            }
        }
        return checkAreaCorrect;
    }

    public static boolean checkAreaInCell(int[][] map, int a, int b) {
        String coordKey = String.format("%02d", a) + String.format("%02d", b);

        if (map.length <= a || map[0].length <= b) {
            return false;
        }
        if (checkedCoordinates.containsKey(coordKey)) {
            return false;
        }
        checkedCoordinates.put(coordKey, 0);

        if (map[a][b] == 0) {
            checkedZeroCoordinates.put(coordKey, 0);
            return true;
        }
        return false;
    }
}