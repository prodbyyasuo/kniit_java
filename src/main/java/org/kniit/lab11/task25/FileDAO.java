package org.kniit.lab11.task25;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileDAO {

    private static final String INSERT_FILE_SQL = "INSERT INTO files (file_name, file_binary) VALUES (?, ?)";

    public void saveFile(File file) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_FILE_SQL);
             FileInputStream fis = new FileInputStream(file)) {

            statement.setString(1, file.getName());

            byte[] fileBytes = new byte[(int) file.length()];
            int bytesRead = fis.read(fileBytes);

            if (bytesRead != -1) {
                statement.setBytes(2, fileBytes);
                statement.executeUpdate();
                System.out.println("Файл сохранен: " + file.getName());
            }

        } catch (SQLException | IOException e) {
            System.err.println("Ошибка при сохранении файла " + file.getName() + ": " + e.getMessage());
        }
    }
}
