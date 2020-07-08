package by.epamtc.jwd.task_array.one_dimensional_array.task3;

/*
 * «Суперзамок». Секретный замок для сейфа состоит из 10 расположенных в рад ячеек, в которые надо вставить
 * игральные кубики. Но дверь открывается только в том случае, когда в любых трех соседних ячейках сумма точек
 * на передних гранях кубиков равна 10. (Игральный кубик имеет на каждой грани от 1 до 6 точек).
 * Напишите программу, которая разгадывает код замка при условии, что два кубика уже вставлены в ячейки
 */

import java.util.Arrays;

public class Solution {

    private byte[] passwordBox;
    private byte indexValue1;
    private byte indexValue2;
    private byte thirdIndex;

    public Solution(byte[] passwordBox) {
        this.passwordBox = passwordBox;
    }

    public byte[] selectionPassword() {
        fillIndexValue();

        if (isCorrectCondition()) {
            System.out.println(indexValue1);
            System.out.println(indexValue2);
            if (passwordBox[indexValue1] == passwordBox[indexValue2]) {
                fillEmptyValue();
            } else {
                fillThirdIndex();
                fillThirdValue();
                settingValues(indexValue1);
                settingValues(indexValue2);
                settingValues(thirdIndex);
            }
        } else {
            System.out.println("неверная последовательность, нельзя открыть сейф!");
        }
        return passwordBox;
    }

    private boolean isCorrectCondition() {
        int sum = 0;

        for (byte value : passwordBox) {
            sum += value;
        }
        return (sum < 10) && isValidIndex(indexValue1, indexValue2);
    }

    private void fillIndexValue() {
        indexValue1 = 10;

        for (int i = 0; i < passwordBox.length; i++) {
            if (passwordBox[i] != 0) {
                if (indexValue1 == 10) {
                    indexValue1 = (byte) i;
                } else {
                    indexValue2 = (byte) i;
                }
            }
        }
    }

    private boolean isValidIndex(byte index1, byte index2) {
        if (passwordBox[index1] == passwordBox[index2]) {

            return true;
        }

        for (int i = 0; i < 4; i++) {

            if (index1 == index2) {
                return false;
            }
            index1 += 3;
        }
        return true;
    }

    private void settingValues(byte index) {
        fillThirdValue();

        if (index == 1 || index == 4 || index == 7) {

            passwordBox[1] = passwordBox[index];
            passwordBox[4] = passwordBox[index];
            passwordBox[7] = passwordBox[index];
        }

        if (index == 0 || index == 3 || index == 6 || index == 9) {

            passwordBox[0] = passwordBox[index];
            passwordBox[3] = passwordBox[index];
            passwordBox[6] = passwordBox[index];
            passwordBox[9] = passwordBox[index];
        }

        if (index == 2 || index == 5 || index == 8) {
            passwordBox[2] = passwordBox[index];
            passwordBox[5] = passwordBox[index];
            passwordBox[8] = passwordBox[index];
        }
    }

    private void fillThirdIndex() {
        for (int i = 0; i < 3; i++) {
            if (isValidIndex((byte) i, indexValue1) && isValidIndex((byte) i, indexValue2)) {
                thirdIndex = (byte) i;
            }
        }
    }

    private void fillThirdValue() {
        passwordBox[thirdIndex] = (byte) (10 - passwordBox[indexValue1] - passwordBox[indexValue2]);
    }

    private void fillEmptyValue() {
        for (int i = 0; i < 10; i++) {
            if (passwordBox[i] == 0) {
                passwordBox[i] = (byte) ((10 - passwordBox[indexValue1]) / 2);
            }
        }
    }
}