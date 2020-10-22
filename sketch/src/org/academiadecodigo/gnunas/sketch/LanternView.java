package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class LanternView {
    private Rectangle leftRectangle;
    private Rectangle rightRectangle;
    private Rectangle upRectangle;
    private Rectangle downRectangle;
    private final int viewZone = 150;

    public LanternView(int initialPlayerX, int initialPlayerY) {

        leftRectangle = new Rectangle(Field.PADDING+Field.DEFAULT_PADDING, Field.PADDING+Field.DEFAULT_PADDING, 0, Field.height);
        //leftRectangle.fill();
        rightRectangle = new Rectangle(Field.DEFAULT_PADDING+Field.PADDING+initialPlayerX+viewZone, Field.PADDING+Field.DEFAULT_PADDING, (Field.width-(initialPlayerX+viewZone)), Field.height);
        //rightRectangle.fill();
        upRectangle = new Rectangle(Field.PADDING+Field.DEFAULT_PADDING, Field.PADDING+Field.DEFAULT_PADDING, Field.width, initialPlayerY-viewZone);
        //upRectangle.fill();
        downRectangle = new Rectangle(Field.PADDING+Field.DEFAULT_PADDING, Field.PADDING+initialPlayerY+viewZone+Field.DEFAULT_PADDING, Field.width, Field.height-(initialPlayerY+viewZone));
        //downRectangle.fill();
    }
    public void moveRight() {
        leftRectangle.grow(1,0);
        leftRectangle.translate(1,0);
        rightRectangle.grow(-1,0);
        rightRectangle.translate(1,0);

    }
    public void moveSpecialRight() {
        rightRectangle.grow(-1,0);
        rightRectangle.translate(1,0);

    }
    public void moveLeft() {
        leftRectangle.grow(-1,0);
        leftRectangle.translate(-1,0);
        rightRectangle.grow(1,0);
        rightRectangle.translate(-1,0);

    }
    public void moveUp() {
        upRectangle.grow(0,-1);
        upRectangle.translate(0,-1);
        downRectangle.grow(0,1);
        downRectangle.translate(0,-1);

    }
    public void moveDown() {
        upRectangle.grow(0,1);
        upRectangle.translate(0,1);
        downRectangle.grow(0,-1);
        downRectangle.translate(0,1);
    }
    public void delete() {
        leftRectangle.delete();
        rightRectangle.delete();
        upRectangle.delete();
        downRectangle.delete();
    }
}
