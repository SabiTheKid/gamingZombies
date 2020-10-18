package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;
import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Key extends GameObject {


    public Key(Position pos) {
        super(pos);
    }

    public void removeKey(){
        super.deletePicture();
    }
}
