package org.academiadecodigo.gnunas.sketch;

public enum Level {
    ONE(5, 20),
    TWO(10, 18),
    THREE(15, 16),
    FOUR(20, 15),
    FIVE(100, 15);

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
