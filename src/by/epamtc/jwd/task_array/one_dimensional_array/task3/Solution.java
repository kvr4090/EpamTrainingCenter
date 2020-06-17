package by.epamtc.jwd.task_array.one_dimensional_array.task3;

/*
 * «Суперзамок». Секретный замок для сейфа состоит из 10 расположенных в рад ячеек, в которые надо вставить
 * игральные кубики. Но дверь открывается только в том случае, когда в любых трех соседних ячейках сумма точек
 * на передних гранях кубиков равна 10. (Игральный кубик имеет на каждой грани от 1 до 6 точек).
 * Напишите программу, которая разгадывает код замка при условии, что два кубика уже вставлены в ячейки
 */

public class Solution {

    private int[] password;
    private int indexValue1;
    private int indexValue2;
    private int indexValue3;
    private int value1;
    private int value2;

    public Solution(int[] password) {
        this.password = password;
    }

    private boolean isValidIndex(int index1, int index2) {
        for (int i = 0; i < 4; i++) {

            if (index1 == index2) {
                return false;
            }
            index1 += 3;
        }
        return true;
    }

    private void fillIndexValue() {
        indexValue1 = 10;

        for (int i = 0; i < password.length; i++) {
            if (password[i] != 0) {
                if (indexValue1 == 10) {
                    indexValue1 = i;
                } else {
                    indexValue2 = i;
                }
            }
        }
    }

    private void setThirdIndex() {
        for (int i = 0; i < 3; i++) {
            if (isValidIndex(i, indexValue1) && isValidIndex(i, indexValue2)) {
                indexValue3 = i;
            }
        }
    }

    private void setThirdValue() {
        password[indexValue3] = 10 - value1 - value2;
    }

    private void fillEmptyValue() {
        boolean flag = true;

        for (int i = 0; i < 10; i++) {
            if (password[i] == 0) {
                if (flag) {
                    password[i] = (int) Math.ceil((10d - value1) / 2);
                    flag = false;

                } else {
                    password[i] = (10 - value1) / 2;
                    flag = true;
                }
            }
        }
    }

    private void fillValues() {
        value1 = password[indexValue1];
        value2 = password[indexValue2];
        int value3 = password[indexValue3];

        if ((value1 == 0) && (value2 == 0)) {
            value1 = (10 - value3) / 2;
            value2 = (10 - value3) / 2;
        }

        if ((value2 == 0) && (value3 == 0)) {
            value2 = (10 - value1) / 2;
            value3 = (10 - value1) / 2;
        }

        if ((value1 == 0) && (value3 == 0)) {
            value1 = (10 - value2) / 2;
            value3 = (10 - value2) / 2;
        }

        password[indexValue1] = value1;
        password[indexValue2] = value2;
        password[indexValue3] = value3;
    }

    private void selectCombination(int index) {

        if ((index == 1) || (index == 4) || (index == 7)) {

            password[1] = password[index];
            password[4] = password[index];
            password[7] = password[index];
        }

        if ((index == 0) || (index == 3) || (index == 6) || (index == 9)) {

            password[0] = password[index];
            password[3] = password[index];
            password[6] = password[index];
            password[9] = password[index];
        }

        if ((index == 2) || (index == 5) || (index == 8)) {
            password[2] = password[index];
            password[5] = password[index];
            password[8] = password[index];
        }
    }

    private boolean isSumCorrect() {
        int sum = 0;

        for (int value : password) {
            sum += value;
        }
        return sum < 10;
    }

    private int[] checkCombination() {
        if (isSumCorrect()) {
            
            fillIndexValue();
            fillValues();

            if (isValidIndex(indexValue1, indexValue2)) {
                
                setThirdIndex();
                setThirdValue();
                
                selectCombination(indexValue1);
                selectCombination(indexValue2);
                selectCombination(indexValue3);
                
            } else {
                if (value1 == value2) {
                    
                    selectCombination(indexValue1);
                    fillEmptyValue();
                    
                } else {
                    System.out.print("неверная последовательность, нельзя открыть сейф!   ");
                }
            }
        } else {
            System.out.print("неверная последовательность, нельзя открыть сейф!   ");
        }

        return password;
    }
}
