package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.Direction;
import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Zombie extends GameObject implements Movable, Collidable{

    public Zombie(Position pos, Picture picture) {
        super(pos, picture);
    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void move() {

    }
}
