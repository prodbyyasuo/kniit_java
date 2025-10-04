package org.kniit.lab2.task4;

class Container {
    private double totalVolume;
    private double remainingVolume;

    public Container(double totalVolume) {
        this.totalVolume = totalVolume;
        this.remainingVolume = totalVolume;
    }

    public String add(Shape shape) {
        double shapeVolume = shape.getVolume();

        if (shapeVolume <= remainingVolume) {
            remainingVolume -= shapeVolume;
            return "Фигура успешно добавлена. Оставшийся объем: " + String.format("%.2f", remainingVolume);
        } else {
            return "Недостаточно места для добавления фигуры. Требуется: " +
                    String.format("%.2f", shapeVolume) + ", доступно: " +
                    String.format("%.2f", remainingVolume);
        }
    }
}