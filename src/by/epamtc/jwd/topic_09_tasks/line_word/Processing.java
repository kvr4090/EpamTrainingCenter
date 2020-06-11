package by.epamtc.jwd.topic_09_tasks.line_word;

/*
 * Решите задачи используя возможности класса String, StringBuilder
 *  Выделение слов из строки
 *  Заменить в самом длинном слове строки буквы 'a' на 'b'
 *  Определить длину самого короткого слова в строке
 *  Подсчет количества слов в строке
 *  Удаление последнего слова в строке
 *  Удаление из строки слов заданной длины
 *  Поменять слова местами
 *  Вывести слова строки в обратном порядке
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class Processing {
    private String workString;
    private String[] arrayWordLine;

    public Processing(String line) {
        workString = line;
        splitLineWord();
    }

    private void splitLineWord() {
        Pattern pattern = Pattern.compile("\\W+");
        arrayWordLine = pattern.split(workString);
    }

    private void sortArrayWord() {
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        Arrays.sort(arrayWordLine, comparator);
    }

    public String[] extractWordsLine() {
        return arrayWordLine;
    }

    public String replaceLetterLongestWord() {
        sortArrayWord();
        String longestWord = arrayWordLine[arrayWordLine.length - 1];
        String newLongestWord = longestWord.replace('a','b');

        return workString.replaceAll(longestWord, newLongestWord);
    }

    public int lengthShortestWord() {
        sortArrayWord();
        return arrayWordLine[0].length();
    }

    public int countWordString() {
        return arrayWordLine.length;
    }

    public String deleteLastWord() {
        String lastWord = arrayWordLine[arrayWordLine.length-1];
        return workString.replaceAll(lastWord, "");
    }

    public String deleteSetLengthWord(int lengthWord) {

        for (String currentWord : arrayWordLine) {
            if (currentWord.length() == lengthWord) {
                workString = workString.replaceAll(currentWord, "");
            }
        }
        return workString;
    }

    public String changePositionWords() {
        StringBuilder newLine = new StringBuilder("");

        if (arrayWordLine.length % 2 == 0) {
            for (int i = 1; i < arrayWordLine.length; i += 2) {
                newLine.append(arrayWordLine[i - 1]).append(" ").append(arrayWordLine[i]).append(" ");
            }
        } else {
            for (int i = 0; i < arrayWordLine.length / 2 ; i++) {
                newLine.append(arrayWordLine[arrayWordLine.length - i - 1]).append(" ").append(arrayWordLine[i]).append(" ");
            }
            newLine.append(arrayWordLine[arrayWordLine.length / 2]);
        }
        return newLine.toString();
    }

    public String reverseWordsLine() {
        StringBuilder newLine = new StringBuilder("");

        for (int i = 0; i < arrayWordLine.length; i++) {
            newLine.append(arrayWordLine[arrayWordLine.length - 1 - i]).append(" ");
        }
        return newLine.toString().trim();
    }
}