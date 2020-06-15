package by.epamtc.jwd.task_array.multidimensional_array.task3;

/*
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

public class Solution {

    private int matrixDimension;

    public Solution(int matrixDimension) {
        this.matrixDimension = matrixDimension;
    }

    public int[][] createFillMatrix() {
        int[][] matrix = new int[matrixDimension][matrixDimension];

        for (int i = 0; i < matrixDimension; i++) {
            for (int j = 0; j < matrixDimension; j++) {
                if (((j >= i) && (j < (matrixDimension - i))) ||
                        ((j <= i) && (j > (matrixDimension - i - 2)))) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public void toScreenMatrix() {
        for (int[] line : createFillMatrix()) {
            for (int value : line) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
