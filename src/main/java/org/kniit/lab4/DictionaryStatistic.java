package org.kniit.lab4;

import java.util.Random;

class DictionaryStatistic {
    private final String[] words;
    private int dictionarySize;
    private int palindrome;
    private int maxWordLength;
    private int minWordLength;
    private final char[] alphabet;
    private final int[] frequency;

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        this.frequency = new int[alphabet.length];
        calculateStatistics();
    }

    private void calculateStatistics() {
        if (words.length == 0) {
            return;
        }

        dictionarySize = words.length;
        maxWordLength = Integer.MIN_VALUE;
        minWordLength = Integer.MAX_VALUE;
        palindrome = 0;

        for (String word : words) {
            if (word == null) continue;

            int length = word.length();
            if (length > maxWordLength) {
                maxWordLength = length;
            }
            if (length < minWordLength) {
                minWordLength = length;
            }

            if (isPalindrome(word)) {
                palindrome++;
            }

            calculateLetterFrequency(word.toLowerCase());
        }
    }

    private boolean isPalindrome(String word) {
        if (word == null || word.isEmpty()) return false;

        String cleanWord = word.toLowerCase();
        int left = 0;
        int right = cleanWord.length() - 1;

        while (left < right) {
            if (cleanWord.charAt(left) != cleanWord.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void calculateLetterFrequency(String word) {
        for (char c : word.toCharArray()) {
            int index = getAlphabetIndex(c);
            if (index != -1) {
                frequency[index]++;
            }
        }
    }

    private int getAlphabetIndex(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public String getRandomWord() {
        if (words == null || words.length == 0) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }

    public void printSymbolsStat() {
        System.out.println("Статистика встречающихся букв:");
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + " - " + frequency[i]);
        }
    }

    public int getDictionarySize() {
        return dictionarySize;
    }

    public int getPalindromeCount() {
        return palindrome;
    }

    public int getMaxWordLength() {
        return maxWordLength;
    }

    public int getMinWordLength() {
        return minWordLength;
    }

    public int[] getFrequency() {
        return frequency.clone();
    }

    public char[] getAlphabet() {
        return alphabet.clone();
    }

    public void printGeneralStat() {
        System.out.println("Общая статистика словаря:");
        System.out.println("Количество слов: " + dictionarySize);
        System.out.println("Количество палиндромов: " + palindrome);
        System.out.println("Максимальная длина слова: " + maxWordLength);
        System.out.println("Минимальная длина слова: " + minWordLength);
    }
}
