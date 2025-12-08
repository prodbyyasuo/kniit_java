package org.kniit.lab9.task15;

public class Main {
    public static void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.println(
                    season.getRusName() + ": " +
                    season.getTemperature() + ", типичный праздник - " +
                    season.getHoliday()
            );
        }
    }
}
