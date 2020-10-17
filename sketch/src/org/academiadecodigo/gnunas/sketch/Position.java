package org.academiadecodigo.gnunas.sketch;


public class Position {

    private int x;
    private int y;
    private Field field;

    public Position(int x, int y, Field fielda) {
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
