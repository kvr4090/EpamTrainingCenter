package by.epamtc.jwd.topic_09_tasks.line;

/*
 * Решите задачи используя возможности класса String, StringBuilder
 *  Четные и нечетные символы разделить по разным строкам
 *  Копирование части строки
 *  Добавление пробелов в строку
 *  Количество вхождений подстроки в строку
 *  Сложение очень длинных целых чисел
 *  Определение длины строки
 *  Процентное соотношение строчных и прописных букв
 *  Удаление одинаковых символов
 *  Частота встречаемости символа в строке
 *  Переворот строки
 *  Вставка подстроки
 *  Удаление подстроки
 *  Замена подстроки в строке
 *  Является ли строка палиндром?
 *  Удаление лишних пробелов
 *  Заменить пробел и группы пробелов символом "*"
 */

import java.math.BigInteger;
import java.util.HashSet;

public class Processing {
    private String workString;
    private String oddSymbols;
    private String evenSymbols;

    public Processing(String line) {
        workString = line;
    }

    public String getLineOddSymbols() {
        separationStringEvenOddSign();
        return oddSymbols;
    }

    public String getLineEvenSymbols() {
        separationStringEvenOddSign();
        return evenSymbols;
    }

    private void separationStringEvenOddSign() {
        StringBuilder evenSign = new StringBuilder("");
        StringBuilder oddSign = new StringBuilder("");

        for (int i = 0; i < workString.toCharArray().length; i++) {
            char sign = workString.toCharArray()[i];

            if (i % 2 == 0) {
                evenSign.append(sign);
            } else {
                oddSign.append(sign);
            }
        }

        oddSymbols = oddSign.toString();
        evenSymbols = evenSign.toString();
    }

    public String indexCopySubstringLine(int startIndex, int endIndex) {
        StringBuilder newLine = new StringBuilder(workString);
        char[] copyBuffer = new char[endIndex - startIndex];
        newLine.getChars(startIndex, endIndex, copyBuffer, 0);

        return newLine.toString();
    }

    public String insertSpaceIndex(int index) {
        StringBuilder newLine = new StringBuilder(workString);
        newLine.insert(index, " ");

        return  newLine.toString();
    }

    public int countSubstringLine(String substring, String line) {
        int result;
        int temp = line.length();
        line = line.replaceAll(substring, "");
        result = (temp - line.length()) / substring.length();

        return result;
    }

    public String sumLongNumber(String firstNumber, String secondNumber) {
        BigInteger value1 = new BigInteger(firstNumber);
        BigInteger value2 = new BigInteger(secondNumber);
        return value1.add(value2).toString();
    }

    public int getLengthLine() {
        return workString.length();
    }

    public double ratioLowerCaseUpperCaseLetter() {
        int lowerCase = 0;
        int upperCase = 0;
        double result = 0;

        for (char symbol : workString.toCharArray()) {
            if (isUpperCase(symbol)) {
                upperCase++;
            } else {
                lowerCase++;
            }
        }

        if ((lowerCase != 0) && (upperCase != 0)) {
            result = (double) (lowerCase / upperCase) * 100;
        }

        return result;
    }

    private boolean isUpperCase(char symbol) {
        return String.valueOf(symbol).equals(String.valueOf(symbol).toUpperCase());
    }

    public String deleteSameSymbol(String sentence) {
        HashSet<Character> noSameSymbol = new HashSet<>();
        StringBuilder uniqueSymbolString = new StringBuilder("");

        for (char symbol : sentence.toCharArray()) {
            if (!noSameSymbol.contains(symbol)) {

                noSameSymbol.add(symbol);
                uniqueSymbolString.append(symbol);
            }
        }

        return uniqueSymbolString.toString();
    }

    public int countGivenSymbolString(char symbol) {
        int count = 0;

        for (char currentSymbol : workString.toCharArray()) {
            if (currentSymbol == symbol) {
                count++;
            }
        }

        return count;
    }

    public String reverseLine() {
        return new StringBuilder(workString).reverse().toString();
    }

    public String insertSubstringFrontLine(String subString) {
        return subString + workString;
    }

    public String insertSubstringBehindLine(String subString) {
        return workString + subString;
    }

    public String insertSubstringIndexLine(String subString, int indexInsert) {
        StringBuilder newLine = new StringBuilder(workString);
        newLine.insert(indexInsert, subString);

        return newLine.toString();
    }

    public String deleteSubstringLine(String subString) {
        return workString.replaceAll(subString,"");
    }

    public String replaceSubstringLine(String substring, String replacement) {
        return workString.replaceAll(substring, replacement);
    }

    public boolean isPalindromeLine() {
        return workString.contentEquals(reverseLine());
    }

    public String deleteExtraSpace() {
        return workString.replaceAll("\\s+", " ").trim();
    }

    public String replaceSpace() {
        return workString.replaceAll("\\s+", "*");
    }
}