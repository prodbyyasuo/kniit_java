package org.kniit.lab10.task23;

public class Main {
    public static <T> void printType(T object) {
        if (object != null) {
            System.out.println(object.getClass().getName());
        } else {
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        printType(123);
        printType("Hello");
        printType(3.14);
    }
}
