package org.academiadecodigo.gnunas.sketch;

public enum Level {
    ONE(20, 15),
    TWO(30, 12),
    THREE(45, 10),
    FOUR(60, 5),
    FIVE(70, 5);

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
