package org.kniit.lab9.task14;

enum TrafficLight {
    RED,
    YELLOW,
    GREEN;

    public TrafficLight getNextLight() {
        return switch (this) {
            case RED  -> GREEN;
            case GREEN -> YELLOW;
            case YELLOW -> RED;
        };
    }
}
