package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private Picture map;
    public static final int PADDING = 32;
    public static final int width = 1024;
    public static final int height = 768;

    public Field(){
        map = new Picture(PADDING, PADDING,"floor_bg.png");
        map.draw();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}