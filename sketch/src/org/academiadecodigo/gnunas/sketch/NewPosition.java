package org.academiadecodigo.gnunas.sketch;

public class NewPosition {

    private int x;
    private int y;
    private Field field;

    public NewPosition(int x, int y, Field fielda) {
        this.x = x;
        this.y = y;
        field = fielda;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveRight() {
        x += 2;
    }
}
