package org.kniit.lab3.task6;

public class WarriorGuard extends Warrior {
    private final int additionalDefence = 10;

    public WarriorGuard(String name) {
        super(name);
        this.defence += additionalDefence;
        this.maxHealth = 180;
        this.health = 180;
    }

    @Override
    public void decreaseHealth(int value) {
        health = health + defence + additionalDefence - value;
        if (health <= 0) {
            health = 0;
            isAlive = false;
            System.out.println(name + " (Танк) погиб!");
        } else {
            System.out.println(name + " (Танк) получил урон. Текущее здоровье: " +
                    health + "/" + maxHealth);
        }
    }

    @Override
    public String toString() {
        return "Воин-Страж (Танк) " + super.toString() +
                " [Доп. защита: " + additionalDefence + "]";
    }
}
