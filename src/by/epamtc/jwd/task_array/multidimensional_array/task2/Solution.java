package by.epamtc.jwd.task_array.multidimensional_array.task2;

/*
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

public class Solution {

    private int matrixDimension;

    public Solution(int matrixDimension) {
        this.matrixDimension = matrixDimension;
    }

    private String[][] createMatrix() {
        String[][] matrix = new String[matrixDimension][matrixDimension];

        for (int i = 0; i < matrixDimension; i++) {
            for (int j = 0; j < matrixDimension; j++) {
                matrix[i][j] = "0";
            }
            matrix[i][i] = (i + 1) + "*" +(i + 2);
        }
        return matrix;
    }

    public void toScreenMatrix() {
        createMatrix();

        for (String[] line : createMatrix()) {
            for (String value : line) {
                System.out.print(value + "\t\t");
            }
            System.out.println();
        }
    }
}
