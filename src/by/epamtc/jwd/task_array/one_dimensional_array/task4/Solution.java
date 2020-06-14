package by.epamtc.jwd.task_array.one_dimensional_array.task4;

/*
 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
 * Если таких чисел несколько, то определить наименьшее из них.
 */

public class Solution {

    private int[] arrayCountRepeat;
    private int max = 2;
    private int min = Integer.MAX_VALUE;
    private int[] workArray;

    public Solution(int[] array) {
        workArray = array;
    }

    private void fillArrayCountRepeat() {
        arrayCountRepeat = new int[workArray.length];

        for (int i = 0; i < workArray.length; i++) {
            for (int value : workArray) {
                if (workArray[i] == value) {

                    arrayCountRepeat[i]++;

                    if (arrayCountRepeat[i] > max) {
                        max = arrayCountRepeat[i];
                    }
                }
            }
        }
    }

    public int oftenMinValue() {
        fillArrayCountRepeat();

        for (int i = 0; i < arrayCountRepeat.length; i++) {
            if ((arrayCountRepeat[i] == max) && (workArray[i]< min)) {
                min = workArray[i];
            }
        }

        return min;
    }
}
