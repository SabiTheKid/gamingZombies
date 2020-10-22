package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObject implements Collidable {

    private Picture picture;
    private Position pos;

    public GameObject(Position pos, Picture picture) {

        this.picture = picture;
        this.pos = pos;
        picture.draw();
    }

    public Picture  getPicture() {
        return picture;
    }

    public Position getPos() {
        return pos;
    }

    public void collided() {

    }




    @Override
    public void collided(GameObject object) {

    }


}
