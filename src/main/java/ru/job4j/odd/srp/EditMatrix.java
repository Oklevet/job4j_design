package ru.job4j.odd.srp;

public class EditMatrix {
    public static void putColumn(String[][] matrix, String str, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col - 1] = str;
        }
    }

    public static void putRow(String[][] matrix, String str, int row) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[row - 1][i] = str;
        }
    }
}
