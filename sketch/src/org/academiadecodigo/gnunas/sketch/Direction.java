package org.academiadecodigo.gnunas.sketch;

public enum Direction {
    RIGHT(1, 0),
    LEFT(-1, 0),
    UP(0, -1),
    DOWN(0, 1);

    private int xDifference;
    private int yDifference;


    Direction(int xDifference, int yDifference) {
        this.xDifference = xDifference;
        this.yDifference = yDifference;
    }

    public boolean isOpposite(Direction direction) {
        switch (this) {
            case DOWN:
                return direction == UP;
            case UP:
                return direction == DOWN;
            case LEFT:
                return direction == RIGHT;
            case RIGHT:
                return direction == LEFT;
            default:
                return false;
        }
    }

    public int getXDifference() {
        return xDifference;
    }

    public int getYDifference() {
        return yDifference;
    }

    public static Direction random() {
        Direction[] directions = values();
        int index = (int) (Math.random() * directions.length);
        return directions[index];
    }
}
