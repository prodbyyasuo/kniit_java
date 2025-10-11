package org.kniit.lab3.task6;

public class Priest extends Player implements Healer {
    private final int healPower;

    public Priest(String name) {
        super(name, 100, 10, 8);
        this.healPower = 30;
    }

    @Override
    public void heal(Player target) {
        if (this.isAlive && target.isAlive()) {
            System.out.println(name + " лечит " + target.getName() +
                    " на " + healPower + " единиц здоровья!");
            target.increaseHealth(healPower);
        } else {
            System.out.println(name + " не может лечить!");
        }
    }

    @Override
    public String toString() {
        return "Жрец " + super.toString() + " [Сила исцеления: " + healPower + "]";
    }
}
