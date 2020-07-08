package by.epamtc.jwd.task_array.multidimensional_array.task4;

/*
 * Дан линейный массив. Получить действительную квадратную матрицу порядка n:
 */

public class Solution {

    private int[] array;

    public Solution(int[] array) {
        this.array = array;
    }

    private int[][] createFillMatrix() {
        int[][] matrix = new int[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                matrix[i][j] = (int) Math.pow(array[j], i + 1);
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