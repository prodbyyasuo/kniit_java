package org.kniit.lab11.task25;

import java.io.File;

public class FileProcessor {

    private static final long MAX_SIZE_BYTES = 10 * 1024 * 1024; // 10 MB
    private final FileDAO fileDAO;

    public FileProcessor() {
        this.fileDAO = new FileDAO();
    }

    public void processFiles(String path) {
        File root = new File(path);

        if (!root.exists()) {
            System.out.println("Путь не найден: " + path);
            return;
        }

        if (root.isFile()) {
            checkAndSave(root);
        } else if (root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        checkAndSave(file);
                    }
                }
            }
        }
    }

    private void checkAndSave(File file) {
        if (file.length() < MAX_SIZE_BYTES) {
            fileDAO.saveFile(file);
        } else {
            System.out.println("Файл пропущен, потому что большого размера. " + file.getName());
        }
    }
}

