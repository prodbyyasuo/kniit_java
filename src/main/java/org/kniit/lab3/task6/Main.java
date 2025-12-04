package org.kniit.lab3.task6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Создание персонажей");
        WarriorGuard warrior = new WarriorGuard("Громбаш Орк");
        Mage mage = new Mage("Эльдрик Мудрый");
        Priest priest = new Priest("Светлана Целительница");

        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);

        System.out.println("\nПеремещение персонажей");
        warrior.moveTo(10, 15);
        mage.moveTo(5, 20);
        priest.moveTo(8, 12);

        System.out.println("\nНачало боя");
        warrior.attack(mage);
        System.out.println(mage);

        System.out.println("\nИсцеление");
        priest.heal(mage);
        System.out.println(mage);

        System.out.println("\nКонтратака мага");
        mage.castSpell(warrior);
        System.out.println(warrior);

        System.out.println("\nСерия атак");
        warrior.attack(mage);
        warrior.attack(mage);
        mage.castSpell(warrior);

        priest.heal(warrior);
        priest.heal(mage);

        System.out.println("\nФинальное состояние персонажей");
        System.out.println(warrior);
        System.out.println(mage);
        System.out.println(priest);

        System.out.println("\nПроверка смерти персонажа");
        if (!mage.isAlive()) {
            System.out.println("Маг погиб и не может быть исцелен");
            priest.heal(mage);
        }
    }
}
