package org.kniit.lab3.task6;

public class Mage extends Player implements Spellcaster{
    private final int spellPower;

    public Mage(String name) {
        super(name, 80, 35, 5);
        this.spellPower = 35;
    }

    @Override
    public void castSpell(Player target) {
        if (this.isAlive && target.isAlive()) {
            System.out.println(name + " произносит заклинание на " +
                    target.getName() + " с силой " + spellPower + "!");
            target.decreaseHealth(spellPower);
        } else {
            System.out.println(name + " не может использовать заклинание!");
        }
    }

    @Override
    public String toString() {
        return "Маг " + super.toString() + " [Сила заклинаний: " + spellPower + "]";
    }

}
