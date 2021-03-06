package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;
import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Key extends GameObject {


    public Key(Position pos) {
        super(pos, new Picture(pos.getX(), pos.getY(), "resources/door_card.png"));
    }

    public void removeKey(){
        super.getPicture().delete();
    }

}
