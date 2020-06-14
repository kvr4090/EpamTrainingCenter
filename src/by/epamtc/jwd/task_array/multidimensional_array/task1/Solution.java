package by.epamtc.jwd.task_array.multidimensional_array.task1;

/*
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

public class Solution {

    private int matrixDimension;

    public Solution(int matrixDimension) {
        this.matrixDimension = matrixDimension;
    }

    private int[][] createMatrix() {
        int[][] matrix = new int[matrixDimension][matrixDimension];

        for (int i = 0; i < matrixDimension; i++) {
            for (int j = 0; j < matrixDimension; j++) {
                if (i % 2 == 0) {
                    matrix[i][j] = j + 1;
                } else {
                    matrix[i][j] = matrixDimension - j;
                }
            }
        }
        return matrix;
    }

    public void toScreenMatrix() {
        createMatrix();

        for (int[] line : createMatrix()) {
            for (int value : line) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}