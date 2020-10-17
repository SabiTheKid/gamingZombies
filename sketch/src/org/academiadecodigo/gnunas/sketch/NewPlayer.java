package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class NewPlayer extends GameObject {

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

}
