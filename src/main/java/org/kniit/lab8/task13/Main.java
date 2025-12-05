package org.kniit.lab8.task13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        System.out.println("Добро пожаловать в систему управления пользователями!");

        boolean running = true;
        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить нового пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("3. Сохранить список пользователей в файл");
            System.out.println("4. Загрузить список пользователей из файла");
            System.out.println("5. Выйти");

            System.out.print("\nВведите номер действия: ");

            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число от 1 до 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    String name;
                    while (true) {
                        System.out.print("Введите имя пользователя: ");
                        name = scanner.nextLine().trim();
                        if (name.isEmpty()) {
                            System.out.println("Имя пользователя не может быть пустым.");
                        } else {
                            break;
                        }
                    }

                    System.out.print("Введите возраст: ");
                    int age = 0;
                    boolean validAge = false;
                    while (!validAge) {
                        try {
                            age = Integer.parseInt(scanner.nextLine());
                            if (age <= 0 || age > 120) {
                                System.out.println("Возраст от 1 до 120 лет.");
                            } else {
                                validAge = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректный возраст.");
                        }
                    }

                    String email;
                    while (true) {
                        System.out.print("Введите email: ");
                        email = scanner.nextLine().trim();

                        if (!isValidEmail(email)) {
                            System.out.println("Ошибка: введите корректный email.");
                        } else {
                            break;
                        }
                    }
                    users.add(new User(name, age, email));
                    System.out.println("Пользователь добавлен.");
                    break;

                case 2:
                    System.out.println("Список пользователей:");
                    if (users.isEmpty()) {
                        System.out.println("(список пуст)");
                    } else {
                        for (int i = 0; i < users.size(); i++) {
                            System.out.println((i + 1) + ". " + users.get(i));
                        }
                    }
                    break;

                case 3:
                    try {
                        UserManager.saveUsers(users);
                        System.out.println("Список успешно сохранён в файл.");
                    } catch (IOException e) {
                        System.out.println("Ошибка при сохранении: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        users = UserManager.loadUsers();
                        System.out.println("Список успешно загружен из файла.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Ошибка при загрузке: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        UserManager.saveUsers(users);
                    } catch (IOException e) {
                        System.out.println("Ошибка автосохранения: " + e.getMessage());
                    }
                    System.out.println("Программа завершена. До свидания!");
                    running = false;
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }

    private static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
