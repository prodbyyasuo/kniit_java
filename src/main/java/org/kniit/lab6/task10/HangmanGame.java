package org.kniit.lab6.task10;

import java.util.*;

public class HangmanGame {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        Collections.addAll(dictionary, "программирование", "компьютер", "алгоритм",
                "монитор", "клавиатура", "интернет", "разработка");

        Random random = new Random();
        String secretWord = dictionary.get(random.nextInt(dictionary.size()));
        System.out.println(secretWord);
        List<Character> wordState = new ArrayList<>();
        for (int i = 0; i < secretWord.length(); i++) {
            wordState.add('_');
        }

        Set<Character> usedLetters = new HashSet<>();

        int lives = 6;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру Виселица!");
        System.out.println("Угадайте слово из " + secretWord.length() + " букв.");

        while (lives > 0) {
            System.out.println("Слово: " + printState(wordState));
            System.out.println("Использованные буквы: " + usedLetters);
            System.out.println("Осталось попыток: " + lives);
            System.out.print("Введите букву: ");

            String input = scanner.next().toLowerCase();

            if (input.length() != 1) {
                System.out.println("Пожалуйста, введите только одну букву.");
                continue;
            }

            char letter = input.charAt(0);

            if (usedLetters.contains(letter)) {
                System.out.println("Вы уже вводили эту букву! Попробуйте другую.");
                continue;
            }

            usedLetters.add(letter);

            if (secretWord.indexOf(letter) != -1) {
                System.out.println("Верно! Буква '" + letter + "' есть в слове.");

                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == letter) {
                        wordState.set(i, letter);
                    }
                }
            } else {
                System.out.println("Неверно! Такой буквы нет.");
                lives--;
            }

            if (!wordState.contains('_')) {
                System.out.println("Вы выиграли!");
                System.out.println("Загаданное слово: " + secretWord);
                return;
            }
        }

        System.out.println("\nВы проиграли. Попытки закончились.");
        System.out.println("Загаданное слово было: " + secretWord);
    }

    private static String printState(List<Character> state) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : state) {
            sb.append(ch).append(" ");
        }
        return sb.toString();
    }
}
