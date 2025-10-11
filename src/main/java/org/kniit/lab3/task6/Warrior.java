package org.kniit.lab3.task6;

public class Warrior extends Player implements Attackable {
    public Warrior(String name) {
        super(name, 150, 25, 15);
    }

    @Override
    public void attack(Player target) {
        if (this.isAlive && target.isAlive()) {
            System.out.println(name + " атакует " + target.getName() +
                    " с силой " + attackPower + "!");
            target.decreaseHealth(attackPower);
        } else {
            System.out.println(name + " не может атаковать!");
        }
    }

    @Override
    public String toString() {
        return "Воин " + super.toString();
    }
}
