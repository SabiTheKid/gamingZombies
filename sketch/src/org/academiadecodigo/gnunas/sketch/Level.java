package org.academiadecodigo.gnunas.sketch;

public enum Level {
    ONE(20, 15),
    TWO(35, 12),
    THREE(50, 8),
    FOUR(75, 5),
    FIVE(90, 1);

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
