package org.kniit.lab6.task11;

import java.util.Scanner;
import java.util.TreeSet;

public class StudentManager {
    public static void main(String[] args) {
        TreeSet<String> students = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Показать всех студентов");
            System.out.println("4. Найти студента");
            System.out.println("5. Выйти");
            System.out.print("Выберите опцию: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Введите имя студента: ");
                    String nameToAdd = scanner.nextLine();

                    if (students.add(nameToAdd)) {
                        System.out.println("Студент добавлен.");
                    } else {
                        System.out.println("Ошибка: такой студент уже есть в списке!");
                    }
                    break;
                case "2":
                    System.out.print("Введите имя студента для удаления: ");
                    String nameToRemove = scanner.nextLine();
                    if (students.remove(nameToRemove)) {
                        System.out.println("Студент удален.");
                    } else {
                        System.out.println("Ошибка: студент не найден в списке.");
                    }
                    break;
                case "3":
                    System.out.println("Список студентов:");
                    if (students.isEmpty()) {
                        System.out.println("Список пуст");
                    } else {
                        for (String student : students) {
                            System.out.println(student);
                        }
                    }
                    break;
                case "4":
                    System.out.print("Введите имя студента для поиска: ");
                    String nameToFind = scanner.nextLine();
                    if (students.contains(nameToFind)) {
                        System.out.println("Студент найден.");
                    } else {
                        System.out.println("Студент не найден.");
                    }
                    break;
                case "5":
                    System.out.println("Выход из программы");
                    return;

                default:
                    System.out.println("Неверная опция. Попробуйте снова.");
            }
        }
    }
}
