package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private Picture map;
    private Rectangle rectangle;
    public final int PADDING = 32;
    public final int width;
    public final int height;

    public Field(){
        this.width = 1024;
        this.height = 768;
        map = new Picture(PADDING, PADDING,"field_bg_2.png");
        map.draw();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}