package org.kniit.lab2.task3;

import java.util.Scanner;

class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        return a / b;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Калькулятор запущен. Для выхода введите 'exit'");

        while (true) {
            System.out.print("Введите первое число: ");
            String firstInput = scanner.nextLine().trim();

            if (firstInput.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы.");
                break;
            }

            double firstNumber = Double.parseDouble(firstInput);

            System.out.print("Введите оператор (+, -, *, /): ");
            String operator = scanner.nextLine().trim();

            if (!operator.equals("+") && !operator.equals("-") &&
                    !operator.equals("*") && !operator.equals("/")) {
                System.out.println("Ошибка: Неверный оператор. Используйте +, -, *, /");
                continue;
            }

            System.out.print("Введите второе число: ");
            String secondInput = scanner.nextLine().trim();

            double secondNumber = Double.parseDouble(secondInput);
            double result;

            switch (operator) {
                case "+":
                    result = calculator.add(firstNumber, secondNumber);
                    break;
                case "-":
                    result = calculator.subtract(firstNumber, secondNumber);
                    break;
                case "*":
                    result = calculator.multiply(firstNumber, secondNumber);
                    break;
                case "/":
                    result = calculator.divide(firstNumber, secondNumber);
                    break;
                default:
                    result = 0;
                    break;
            }
            System.out.println("Результат: " + result);
            System.out.println();
        }
        scanner.close();
    }
}