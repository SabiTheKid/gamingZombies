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
<<<<<<< HEAD
        x += 1;
    }

    public void moveLeft(){
        x -= 1;
    }

    public void moveUp(){
        y -= 1;
    }

    public void moveDown(){
        y += 1;
=======
        x += 2;
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
    }

}

