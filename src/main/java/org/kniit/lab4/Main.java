package org.kniit.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("misc/dictionary.txt"));
            ArrayList<String> wordList = new ArrayList<>();

            while (scanner.hasNext()) {
                wordList.add(scanner.nextLine());
            }
            scanner.close();

            String[] words = wordList.toArray(new String[0]);
            char[] alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();

            DictionaryStatistic stat = new DictionaryStatistic(words, alphabet);
            stat.printGeneralStat();
            System.out.println();
            stat.printSymbolsStat();
            System.out.println();

            System.out.println("Случайные слова из словаря:");
            for (int i = 0; i < 5; i++) {
                String randomWord = stat.getRandomWord();
                System.out.println((i + 1) + ". " + randomWord);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        }
    }
}
