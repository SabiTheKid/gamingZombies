package org.academiadecodigo.gnunas.sketch;


public class Position {
    private int x;
    private int y;

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

    public void moveRight(boolean keyHolder, LanternView lanternView) {

        if (x >= Field.width-1 && (y == Field.height/2 || y == Field.height/2+1) && keyHolder == true){
            x += 2;
        }
        if(x == Field.PADDING + Field.width-32 || x == Field.PADDING + Field.width-31){
            return;
        }
        x += 2;
        if(x<150) {
            lanternView.moveSpecialRight();
            return;
        }
        lanternView.moveRight();
    }

    public void moveLeft(LanternView lanternView){
        if (x <= Field.PADDING+1){
            return;
        }
        x -= 2;
        lanternView.moveLeft();
    }

    public void moveUp(LanternView lanternView){
        if (y <= Field.PADDING+1){
            return;
        }
        y -= 2;
        lanternView.moveUp();
    }
    public void moveUp(){
        y -= 1;
    }

    public void moveDown(LanternView lanternView){
        if (y >= Field.PADDING + Field.height-31){
            return;
        }
        y += 2;
        lanternView.moveDown();

    }
    public void move(Direction direction) {
        x += direction.getXDifference();
        y += direction.getYDifference();
    }

}

