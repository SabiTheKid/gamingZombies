package org.academiadecodigo.gnunas.sketch;


public class Position {
    private int x;
    private int y;
    private int padding = Field.PADDING;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveRight() {
        if(x == Field.PADDING + Field.width-32){
            return;
        }
        x += 1;
    }

    public void moveLeft(){
        if (x == Field.PADDING){
            return;
        }
        x -= 1;
    }

    public void moveUp(){
        if (y == Field.PADDING){
            return;
        }
        y -= 1;
    }

    public void moveDown(){
        if (y == Field.PADDING + Field.height-32){
            return;
        }
        y += 1;

    }

}

