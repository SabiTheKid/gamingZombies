package org.academiadecodigo.gnunas.sketch;

import java.awt.*;

public class Player {

    private boolean keyHolder;
    private boolean alive;
    private Position pos;
    private Rectangle player;

    public Player(){
      //Insert position, graphic representation, alive = true etc...
    }

    public boolean isKeyHolder() {
        return keyHolder;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setKeyHolder(boolean keyHolder){
        this.keyHolder = keyHolder;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Position move(){
        // Keypress right = move right, left = move left, up = move up, down = move down....
        //check with collision detector if he can move or not
        return null;
    }
}
