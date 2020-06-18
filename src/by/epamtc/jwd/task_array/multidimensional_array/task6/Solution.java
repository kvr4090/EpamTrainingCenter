package by.epamtc.jwd.task_array.multidimensional_array.task6;

public class Solution {
  
  public int[][] oddN(int n) {
        int[][] magicSquare = new int[n][n];
        int number = 1;
        int row = 0;
        int column = n / 2;
        int currentRow;
        int currentCol;

        while (number <= n * n) {
            magicSquare[row][column] = number;
            number ++;
            currentRow = row;
            currentCol = column;
            row -= 1;
            column += 1;

            if (row == -1) {
                row = n - 1;
            }

            if (column == n) {
                column = 0;
            }

            if (magicSquare[row][column] != 0) {
                row = currentRow + 1;
                column = currentCol;

                if (row == -1) {
                    row = n - 1;
                }
            }
        }

        return magicSquare;
}
