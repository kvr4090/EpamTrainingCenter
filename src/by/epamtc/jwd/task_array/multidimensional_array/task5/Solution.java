package by.epamtc.jwd.task_array.multidimensional_array.task5;

/*
 * Найдите произведение двух матриц.
 */

public class Solution {
  
    private int[][] firstMatrix;
    private int[][] secondMatrix;

    public void setFirstMatrix(int[][] firstMatrix) {
        this.firstMatrix = firstMatrix;
    }

    public void setSecondMatrix(int[][] secondMatrix) {
        this.secondMatrix = secondMatrix;
    }

    private int[][] createFillResultMatrix() {
        int z = firstMatrix.length;
        int x = secondMatrix[0].length;
        int c = secondMatrix.length;
        int[][] resultMatrix = new int[z][x];

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < c; k++) {
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return resultMatrix;
    }

    public void toScreenResultMatrix() {
        for (int[] line : createFillResultMatrix()) {
            for (int value : line) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
