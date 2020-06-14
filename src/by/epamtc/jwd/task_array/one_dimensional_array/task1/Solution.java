package by.epamtc.jwd.task_array.one_dimensional_array.task1;

/*
 * Даны действительные числа  . Найти необходимое.
 */

public class Solution {

    public double findMaxValueSequence(double[] array) {
        double[] workArray = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            workArray[i] = array[i] + array.length * 2 - i;
        }

        return findMaxValueArray(workArray);
    }

    private double findMaxValueArray(double[] array) {
        double maxValue = Double.MIN_VALUE;

        for (double value : array) {
            maxValue = Math.max(maxValue, value);
        }

        return maxValue;
    }
}