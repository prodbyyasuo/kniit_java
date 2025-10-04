package org.kniit.lab2.task4;

public class Main {
    public static void main(String[] args) {
        // Создаем контейнер с объемом 1000
        Container container = new Container(1000);

        // Создаем фигуры
        Shape sphere = new Sphere(5);   // Сфера с радиусом 5
        Shape cube = new Cube(3);       // Куб со стороной 3
        Shape cylinder = new Cylinder(2, 5); // Цилиндр с радиусом 2 и высотой 5

        // Выводим объемы фигур
        System.out.println("Объем сферы: " + String.format("%.2f", sphere.getVolume()));
        System.out.println("Объем куба: " + String.format("%.2f", cube.getVolume()));
        System.out.println("Объем цилиндра: " + String.format("%.2f", cylinder.getVolume()));
        System.out.println();

        // Добавляем фигуры в контейнер
        System.out.println(container.add(sphere));
        System.out.println(container.add(cube));
        System.out.println(container.add(cylinder));
        System.out.println();

        // Пытаемся добавить слишком большую фигуру
        Shape bigCube = new Cube(10);
        System.out.println("Объем большого куба: " + String.format("%.2f", bigCube.getVolume()));
        System.out.println(container.add(bigCube));
    }
}