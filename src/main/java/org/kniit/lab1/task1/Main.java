package org.kniit.lab1.task1;

public class Main {
    public static void main(String[] args) {
        String line = "";

        for (int i = 1; i <= 100; i++) {
            line += i;

            if (i < 100) {
                line += ", ";
            }

            if (i % 10 == 0) {
                line += "\n";
            }
        }

        System.out.println(line);
    }
}