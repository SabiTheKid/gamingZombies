package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.Player;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        game.init();
        try {
            game.initLevelTwo();
        } catch (Exception ex){
            System.out.println(ex);
        }



    }
}
