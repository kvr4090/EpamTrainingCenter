package by.epamtc.jwd.task_array.one_dimensional_array.task2;
/*
 * Дана последовательность целых чисел  . Образовать новую последовательность,
 * выбросив из исходной те члены, которые равны min.
 */
public class Solution {

    public int[] deleteMinValueSequence(int[] sequence) {
        int[] newSequence = new int[sequence.length - 1];
        int counter = 0;

        for (int value : sequence) {
            if (value != minValue(sequence)) {
                newSequence[counter] = value;
                counter++;
            }
        }

        return newSequence;
    }

    private int minValue(int[] array) {
        int minValue = Integer.MAX_VALUE;

        for (int value : array) {
            minValue = Math.min(minValue, value);
        }

        return minValue;
    }
}
