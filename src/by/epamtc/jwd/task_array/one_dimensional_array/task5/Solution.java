package by.epamtc.jwd.task_array.one_dimensional_array.task5;

/*
 * . Дан одномерный массив A[N]. Найти: max(even) + min(odd)
 */
public class Solution {

    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    private int[] workArray;

    public Solution(int[]array) {
        this.workArray = array;
    }

    private void searchMinMaxValues() {
        for (int value : workArray) {
            if (value % 2 == 0) {
                if (value > max) {
                    max = value;
                }
            } else {
                if (value < min) {
                    min = value;
                }
            }
        }
    }

    public int sumMaxEvenMinOdd() {
        searchMinMaxValues();
        return max + min;
    }
}