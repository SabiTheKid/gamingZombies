package org.academiadecodigo.gnunas.sketch;

public enum Level {
    ONE(20, 40),
    TWO(30, 30),
    THREE(45, 20),
    FOUR(60, 10),
    FIVE(70, 1);

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
