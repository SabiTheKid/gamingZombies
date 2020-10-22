package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {

    private Picture map;
    public static final int DEFAULT_PADDING = 10;
    public static final int PADDING = 32;
    public static final int width = 1024;
    public static final int height = 768;

    public Field(){
        map = new Picture(PADDING+DEFAULT_PADDING, PADDING+DEFAULT_PADDING,"field_bg_4.png");
        map.draw();
    }

    public Picture getMap() {
        return map;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}