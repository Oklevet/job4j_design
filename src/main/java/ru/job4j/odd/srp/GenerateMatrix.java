package ru.job4j.odd.srp;

public class GenerateMatrix {
    public String[][] generateMatrix(String str, int row, int col) {
        String[][] matrix = new String[row][col];
         for (int i = 0; i < row; i++) {
             for (int j = 0; j < col; j++) {
                 matrix[i][j] = str;
             }
         }
         return matrix;
    }
}
