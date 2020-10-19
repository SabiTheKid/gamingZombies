package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Door extends GameObject{
    private boolean opened;
    public Door(Position pos) {
        super(pos, new Picture());
    }

    public void openDoor(){
        opened = true;
        super.getPos().moveUp();
        super.getPicture().load(/*adress of the new image*/);

    }
}
