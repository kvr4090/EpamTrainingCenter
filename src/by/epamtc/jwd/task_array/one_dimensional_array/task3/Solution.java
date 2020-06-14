package by.epamtc.jwd.task_array.one_dimensional_array.task3;

/*
 * «Суперзамок». Секретный замок для сейфа состоит из 10 расположенных в рад ячеек, в которые надо вставить
 * игральные кубики. Но дверь открывается только в том случае, когда в любых трех соседних ячейках сумма точек
 * на передних гранях кубиков равна 10. (Игральный кубик имеет на каждой грани от 1 до 6 точек).
 * Напишите программу, которая разгадывает код замка при условии, что два кубика уже вставлены в ячейки
 */

public class Solution {

    public int[] selectionPassword(int[] passwordBox) {
        int number1;
        int number2;
        int number3;

        for (int i = 1; i < 9; i++) {
            number1 = passwordBox[i - 1];
            number2 = passwordBox[i];
            number3 = passwordBox[i + 1];

            if (number1 + number2 + number3 == 0) {
                continue;
            }

            if (number1 == 0) {
                if (number2 != 0) {
                    if (number3 != 0) {
                        number1 = selectNumber(number2, number3);
                    } else {
                        number1 = selectNumbers(number2)[0];
                        number3 = selectNumbers(number2)[1];
                    }
                } else {
                    number1 = selectNumbers(number3)[0];
                    number2 = selectNumbers(number3)[1];
                }
            } else {
                if (number2 == 0) {
                    if (number3 == 0) {
                        number2 = selectNumbers(number1)[0];
                        number3 = selectNumbers(number1)[1];
                    } else {
                        number2 = selectNumber(number1, number3);
                    }
                } else {
                    number3 = selectNumber(number1, number2);
                }
            }

            passwordBox[i - 1] = number1;
            passwordBox[i] = number2;
            passwordBox[i + 1] = number3;
            break;
        }
        return passwordBox;
    }

    private int[] selectNumbers(int value) {

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (i + j + value == 10) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    private int selectNumber(int value1, int value2) {
        return 10 - value1 - value2;
    }
}
