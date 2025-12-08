package org.kniit.lab9.task14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        String input = scanner.nextLine();

        try {
            TrafficLight currentLight = TrafficLight.valueOf(input.toUpperCase().trim());

            TrafficLight nextLight = currentLight.getNextLight();

            System.out.println("Следующий сигнал: " + nextLight);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: такого сигнала светофора не существует.");
        }
    }
}
