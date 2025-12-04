package org.kniit.lab7.task12;

import java.io.IOException;
import java.nio.file.*;

public class DirectoryWordCounter {

    public static void main(String[] args) {
        Path startPath = Paths.get("test_dir1");

        WordCountVisitor visitor = new WordCountVisitor();

        try {
            System.out.println("Начинаем обход файлов в: " + startPath.toAbsolutePath());

            Files.walkFileTree(startPath, visitor);

            System.out.println("Обход завершен.");
            System.out.println("Всего обработано .txt файлов: " + visitor.getTxtFilesCount());
            System.out.println("Общее количество слов: " + visitor.getTotalWords());
        } catch (IOException e) {
            System.out.println("Ошибка при обходе файлов: " + e.getMessage());
        }
    }
}
