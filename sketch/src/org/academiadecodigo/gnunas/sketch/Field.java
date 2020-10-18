package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private Rectangle map;
    public final int PADDING = 10;
    public final int width;
    public final int height;

    public Field(){
        this.width = 1900;
        this.height = 1060;
        map = new Rectangle(PADDING, PADDING, width, height);
        //map = new Picture(PADDING, PADDING,"game_field.jpg");
        map.draw();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}