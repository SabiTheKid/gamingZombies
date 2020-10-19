package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Door extends GameObject{

    private boolean opened;

    public Door(Position pos) {
        super(pos, new Picture());
        opened = false;
    }

    public void openDoor(){
        opened = true;
        super.getPos().moveUp();
        super.getPicture().load("");

    }

    public boolean isOpened() {
        return opened;
    }

}
