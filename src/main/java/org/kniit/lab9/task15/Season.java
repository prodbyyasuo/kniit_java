package org.kniit.lab9.task15;

enum Season {
    WINTER("Зима", "Холодно", "Новый год"),
    SPRING("Весна", "Тепло", "Пасха"),
    SUMMER("Лето", "Жарко", "День Независимости"),
    AUTUMN("Осень", "Прохладно", "Хэллоуин");

    private final String rusName;
    private final String temperature;
    private final String holiday;

    Season(String rusName, String temperature, String holiday) {
        this.rusName = rusName;
        this.temperature = temperature;
        this.holiday = holiday;
    }

    public String getRusName() {
        return rusName;
    }
    public String getTemperature() {
        return temperature;
    }

    public String getHoliday() {
        return holiday;
    }
}
