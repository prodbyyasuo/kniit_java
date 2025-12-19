package org.kniit.lab5.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Keyboard {

    public static void main(String[] args) {
        List<String> dictionary;
        try {
            dictionary = getWords("misc/dictionary.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Нажмите Enter, чтобы начать тренировку");
        scanner.nextLine();

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 10000;

        int totalWordsShown = 0;
        int correctWords = 0;
        int totalCharsEntered = 0;

        System.out.println("Таймер запущен!");

        while (System.currentTimeMillis() < endTime) {
            String targetWord = dictionary.get(random.nextInt(dictionary.size()));
            System.out.print(targetWord + ": ");

            String input = scanner.next();

            if (System.currentTimeMillis() > endTime) {
                System.out.println("\n\nВремя вышло. Последнее слово не учитывается");
                break;
            }

            totalWordsShown++;
            totalCharsEntered += input.length();

            if (input.equals(targetWord)) {
                correctWords++;
            }
        }

        double charsPerSecond = (double) totalCharsEntered / 60.0;

        System.out.println("Результаты");
        System.out.println("Всего слов предложено: " + totalWordsShown);
        System.out.println("Правильных слов: " + correctWords);
        System.out.println("Введено символов: " + totalCharsEntered);
        System.out.printf("Скорость: %.2f символов в секунду%n", charsPerSecond);
    }

    public static List<String> getWords(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            String word = scanner.next();
            words.add(word);
        }
        scanner.close();
        return words;
    }
}
