package org.kniit.lab3.task6;

public abstract class Player {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected boolean isAlive;
    protected int positionX;
    protected int positionY;
    protected int attackPower;
    protected int defence;

    public Player(String name, int maxHealth, int attackPower, int defence) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.isAlive = true;
        this.positionX = 0;
        this.positionY = 0;
        this.attackPower = attackPower;
        this.defence = defence;
    }

    public void increaseHealth(int value) {
        if (isAlive) {
            health += value;
            if (health > maxHealth) {
                health = maxHealth;
            }
            System.out.println(name + " восстановил здоровье на " + value + ". Текущее здоровье: " + health + "/" + maxHealth);
        }
    }

    public void decreaseHealth(int value) {
        health = health + defence - value;
        if (health <= 0) {
            health = 0;
            isAlive = false;
            System.out.println(name + " погиб!");
        } else {
            System.out.println(name + " получил урон. Текущее здоровье: " +
                    health + "/" + maxHealth);
        }
    }

    public void moveTo(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        System.out.println(name + " переместился на позицию (" + x + ", " + y + ")");
    }

    public String getName() {
        return name;

    }
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return String.format("%s [Здоровье: %d/%d, Статус: %s, Позиция: (%d, %d), " +
                        "Урон: %d, Защита: %d]",
                name, health, maxHealth, isAlive ? "Жив" : "Мертв",
                positionX, positionY, attackPower, defence);
    }
}
