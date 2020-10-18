package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;
<<<<<<< HEAD
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class NewPlayer extends GameObject {
=======
import org.academiadecodigo.gnunas.sketch.GameObject.Key;
import org.academiadecodigo.gnunas.sketch.GameObject.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class NewPlayer extends GameObject implements Movable {
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409

    public boolean alive;
    public boolean keyHolder;

    public NewPlayer(Position pos, Rectangle picture) {
        super(pos, picture);
        alive = true;
        keyHolder = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setKeyHolder(boolean holder){
        this.keyHolder = holder;
    }

<<<<<<< HEAD
=======
    @Override
    public void collided(GameObject object) {

        if (object instanceof Key) {
            Key key = (Key) object;
            setKeyHolder(true);
            key.removeKey();
        }

        // else is a GameObject and the player has to change the direction of the movement

        // for example invoking the method move after asking for a new movement


    }

    @Override
    public void move() {

    }
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
}
