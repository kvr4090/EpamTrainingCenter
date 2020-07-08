package by.epamtc.jwd.task_array.multidimensional_array.task6;

/*
 * Построить магический квадрат
 */

import java.util.Date;

public class Solution {

    private int value1;
    private int value2;

    public int[][] returnMagicSquare(int n) {
        if ( n > 0) {
            if (n % 2 == 0) {
                return evenN(n);
            } else {
                return oddN(n);
            }
        } else {
            System.out.println("Проверьте значение N");
            return  new int[0][0];
        }
    }

    private int[][] oddN(int n) {
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

    private int[][] evenN(int n) {
        int[][] squareMagic = new int[n][n];
        fill(squareMagic);
        reverse1(squareMagic);
        reverse2(squareMagic);
        return squareMagic;
    }

    private void fill(int[][] matrix) {
        int k = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = k;
                k++;
            }
        }
    }

    private void reverse1(int[][] matrix) {
        for (int i = 0; i <= matrix.length/2; i++) {
            for (int j = 0; j <= matrix.length/2; j++) {
                if (i%2 == 0) {
                    if (j%2!=0) {
                        value1 = matrix[i][j];
                        value2 = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                        swapValues();
                        matrix[i][j] = value1;
                        matrix[matrix.length - 1 - i][matrix.length - 1 - j] = value2;
                    }
                } else {
                    if (j%2 ==0) {
                        value1 = matrix[i][j];
                        value2 = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                        swapValues();
                        matrix[i][j] = value1;
                        matrix[matrix.length - 1 - i][matrix.length - 1 - j] = value2;
                    }
                }
            }
        }
    }

    private void reverse2(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length/2; i++) {
            for (int j = length/2; j < length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        value1 = matrix[i][j];
                        value2 = matrix[length-1-i][length-j-1];
                        swapValues();
                        matrix[i][j] = value1;
                        matrix[length-1-i][length-j-1] = value2;
                    }
                } else {
                    if (j % 2 != 0) {
                        value1 = matrix[i][j];
                        value2 = matrix[length-1-i][length-j-1];
                        swapValues();
                        matrix[i][j] = value1;
                        matrix[length-1-i][length-j-1] = value2;
                    }
                }
            }
        }
    }



    private void swapValues() {
        int temp = value1;
        value1 = value2;
        value2 = temp;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        ss.returnMagicSquare(9999);
        //soutMatrix(ss.returnMagicSquare(301));
        //soutSumm(ss.returnMagicSquare(301));
        //System.out.println();
    }

    public static void soutMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }

    }

    public static void soutSumm(int[][] matrix) {
        int summ = 0;
        int sum2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                summ += matrix[i][j];
                sum2 += matrix[j][i];
            }
            System.out.print("cумма " + (i+1) +" ряда " + summ + " ");
            System.out.print("cумма " + (i+1) +" столбца " + sum2 + " ");
            System.out.println();
            summ = 0;
            sum2 = 0;
        }
    }

}
