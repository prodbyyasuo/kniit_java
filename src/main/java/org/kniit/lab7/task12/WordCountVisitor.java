package org.kniit.lab7.task12;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class WordCountVisitor extends SimpleFileVisitor<Path> {
    private long totalWords = 0;
    private int txtFilesCount = 0;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".txt")) {
            long wordsInFile = countWordsInFile(file);
            totalWords += wordsInFile;
            txtFilesCount++;

            System.out.printf("Файл: %s, слов: %d%n", file.getFileName(), wordsInFile);
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println("Не удалось прочитать файл: " + file + " (" + exc.getMessage() + ")");
        return FileVisitResult.CONTINUE;
    }

    private long countWordsInFile(Path file) {
        long count = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла " + file);
        }
        return count;
    }

    public long getTotalWords() {
        return totalWords;
    }

    public int getTxtFilesCount() {
        return txtFilesCount;
    }
}
