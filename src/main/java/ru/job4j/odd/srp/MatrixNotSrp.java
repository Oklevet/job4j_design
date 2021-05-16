package ru.job4j.odd.srp;

import java.util.Arrays;

public class MatrixNotSrp {
    /**
     * Вынести создание матрицы в отдельный класс
     */
    public static String[][] generateMatrix(String str, int row, int col) {
        String[][] matrix = new String[row][col];
         for (int i = 0; i < row; i++) {
             for (int j = 0; j < col; j++) {
                 matrix[i][j] = str;
             }
         }
         return matrix;
    }

    /**
     * Производить редактирование в матрице
     */
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

    /**
     * Подключить вывод информации через интерфейс
     */
    public static void print(String[][] msg) {
        for (String[] str : msg) {
             Arrays.stream(str).forEach(System.out::print);
             System.out.println();
         }
    }

    public static void main(String[] args) {
         String[][] matrix = generateMatrix("+", 5, 5);
         putColumn(matrix, "W", 3);
         putRow(matrix, "W", 2);
         print(matrix);
    }
}
