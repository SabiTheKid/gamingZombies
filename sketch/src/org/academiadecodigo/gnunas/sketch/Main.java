package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.Player;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(20);

        game.init();
        try {
            game.start();
        } catch (Exception ex){
            System.out.println(ex);
        }



    }
}
