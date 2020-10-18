package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.Player;

public class Main {

    public static void main(String[] args) {

        Field field = new Field();
        GameObjectFactory.createWallLimits(field);
        Player player = new Player(field);
        //Key key = new Key(new Position(50, 50, field), new Rectangle(50, 50, 10,10));
        player.move();

    }
}
