package ru.job4j.tasks.bidimarray;

public class BattleShip {
    public int countAliveShips(int[][] sea) {
        int countShips = 0;
        int verticalShip = 0;
        int horizShip = 0;



        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < sea[i].length; j++) {
                if (sea[i][j] == 1) {
                    horizShip++;
                } else {
                    if (horizShip > 1) {
                        countShips++;
                    } else if (horizShip == 1) {
                        if (checkOneDeckShip(sea, i, j - 1)) {
                            countShips++;
                        }
                    }
                    horizShip = 0;
                }

                if (sea[j][i] == 1) {
                    verticalShip++;
                } else {
                    if (verticalShip > 1) {
                        countShips++;
                    }
                    verticalShip = 0;
                }
            }

            if (horizShip > 1) {
                countShips++;
            } else if (horizShip == 1) {
                if (checkOneDeckShip(sea, i, sea[i].length - 1)) {
                    countShips++;
                }
            }

            if (verticalShip > 1) {
                countShips++;
            }

            horizShip = 0;
            verticalShip = 0;
        }
        return countShips;
    }

    public static boolean checkOneDeckShip(int[][] sea, int a, int b) {
        if (b == -1) {
            b = 0;
        }
        return !checkCrossCellsForShips(sea, a, b);
    }

    public static boolean checkCrossCellsForShips(int[][] sea, int a, int b) {
        boolean foundShip = false;
        if (b > 0) {
            if (checkShipInCell(sea, a, b - 1)) {
                return true;
            }
        }
        if (a > 0) {
            if (checkShipInCell(sea, a - 1, b)) {
                return true;
            }
        }
        if (a < sea[0].length - 1) {
            if (checkShipInCell(sea, a + 1, b)) {
                return true;
            }
        }
        if (b < sea.length - 1) {
            if (checkShipInCell(sea, a, b + 1)) {
                return true;
            }
        }
        return foundShip;
    }

    public static boolean checkShipInCell(int[][] sea, int a, int b) {
        return sea[a][b] == 1;
    }
}
