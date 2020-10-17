package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GameObject implements Collidable {

    private Rectangle picture;
    private Position pos;

    public GameObject(Position pos, Rectangle picture) {

        this.picture = picture;
        this.pos = pos;
        picture.draw();
    }

    public Position getPos() {
        return pos;
    }

    public void collided(){

    }
}
