package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObject implements Collidable {

    private Picture picture;
    private Position pos;

    public GameObject(Position pos, Picture picture) {

        this.picture = picture;
        this.pos = pos;
        picture.draw();
    }

    public Position getPos() {
        return pos;
    }
}

    /*@Override
    public boolean isColliding(GameObject object) {

        return (this.pos.equals(object.pos));

    }
}*/
