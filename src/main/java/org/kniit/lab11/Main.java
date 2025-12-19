package org.kniit.lab11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Запуск приложения. Введите 'help' для списка команд.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split("\\s+");
            String command = parts[0].toLowerCase();

            switch (command) {
                case "add":
                    if (parts.length < 3) {
                        System.out.println("Использование: add [name] [email]");
                        break;
                    }
                    String emailAdd = parts[parts.length - 1];
                    String nameAdd = input.substring(4, input.lastIndexOf(emailAdd)).trim();
                    userService.registerUser(nameAdd, emailAdd);
                    break;

                case "list":
                    userService.listAllUsers();
                    break;

                case "delete":
                    if (parts.length < 2) {
                        System.out.println("Использование: delete [id]");
                        break;
                    }
                    try {
                        int idDel = Integer.parseInt(parts[1]);
                        userService.deleteUser(idDel);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: ID должен быть числом.");
                    }
                    break;

                case "update":
                    if (parts.length < 4) {
                        System.out.println("Использование: update [id] [new_name] [new_email]");
                        break;
                    }
                    try {
                        int idUpd = Integer.parseInt(parts[1]);
                        String emailUpd = parts[parts.length - 1];
                        int idEndIndex = input.indexOf(parts[1]) + parts[1].length();
                        int emailStartIndex = input.lastIndexOf(emailUpd);
                        String nameUpd = input.substring(idEndIndex, emailStartIndex).trim();

                        userService.updateUser(idUpd, nameUpd, emailUpd);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: ID должен быть числом.");
                    }
                    break;

                case "exit":
                    System.out.println("Выход из программы.");
                    return;

                case "help":
                    System.out.println("Доступные команды:");
                    System.out.println("  add [name] [email] - добавить пользователя");
                    System.out.println("  list - список всех пользователей");
                    System.out.println("  delete [id] - удалить пользователя");
                    System.out.println("  update [id] [name] [email] - обновить данные");
                    System.out.println("  exit - выход");
                    break;

                default:
                    System.out.println("Неизвестная команда. Введите 'help' для справки.");
            }
        }
    }
}

