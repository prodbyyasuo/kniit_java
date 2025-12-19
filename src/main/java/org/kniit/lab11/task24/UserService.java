package org.kniit.lab11.task24;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAOImpl();

    public void registerUser(String name, String email) {
        try {
            if (userDAO.emailExists(email)) {
                System.out.println("Ошибка: Пользователь с таким email уже существует.");
                return;
            }
            User newUser = new User(name, email);
            userDAO.create(newUser);
            System.out.println("Пользователь успешно добавлен.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listAllUsers() {
        try {
            List<User> users = userDAO.findAll();
            if (users.isEmpty()) {
                System.out.println("Список пользователей пуст.");
            } else {
                System.out.println("Список пользователей:");
                for (User user : users) {
                    System.out.println(user);
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка БД: " + e.getMessage());
        }
    }

    public void deleteUser(int id) {
        try {
            if (userDAO.findById(id) == null) {
                System.out.println("Ошибка: Пользователь с ID " + id + " не найден.");
                return;
            }
            userDAO.delete(id);
            System.out.println("Пользователь удален.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateUser(int id, String newName, String newEmail) {
        try {
            User existingUser = userDAO.findById(id);
            if (existingUser == null) {
                System.out.println("Ошибка: Пользователь с ID " + id + " не найден.");
                return;
            }

            if (!existingUser.getEmail().equals(newEmail) && userDAO.emailExists(newEmail)) {
                System.out.println("Ошибка: Email " + newEmail + " уже занят.");
                return;
            }

            existingUser.setName(newName);
            existingUser.setEmail(newEmail);
            userDAO.update(existingUser);
            System.out.println("Данные пользователя обновлены.");
        } catch (SQLException e) {
            System.out.println("Ошибка БД: " + e.getMessage());
        }
    }
}
