package org.academiadecodigo.gnunas.sketch;

public enum Level {
    ONE(20, 50),
    TWO(30, 40),
    THREE(40, 30),
    FOUR(50, 20),
    FIVE(60, 10),
    SIX(70,5),
    SEVEN(80,2),
    EIGHT(90,1),
    NINE(100,1),
    TEN(120,1);

    private int numberOfZombies;
    private int delay;

    Level(int numberOfZombies, int delay) {
        this.numberOfZombies = numberOfZombies;
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }

    public int getNumberOfZombies() {
        return numberOfZombies;
    }
}
