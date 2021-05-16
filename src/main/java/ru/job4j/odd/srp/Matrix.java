package ru.job4j.odd.srp;

import java.util.Arrays;

public class Matrix implements Output {

    public static void main(String[] args) {
        GenerateMatrix genMat = new GenerateMatrix();
        EditMatrix editMat = new EditMatrix();
         String[][] matrix = genMat.generateMatrix("+", 5, 5);
         editMat.putColumn(matrix, "W", 3);
         editMat.putRow(matrix, "W", 2);
         Output.print(matrix);
    }
}
