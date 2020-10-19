package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.Door;
import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;
import org.academiadecodigo.gnunas.sketch.GameObject.Player;
import org.academiadecodigo.gnunas.sketch.GameObject.Zombie;

import java.util.List;

public class Game {

    private Field field;
    private CollisionDetector collisiondetector;
    private List<GameObject> gameObjects;
    private GameObjectFactory gameObjectFactory;
    private int delay;
    private Player player;
    private Door door;

    public Game(int delay){
        this.delay = delay;
    }

    public void init(){
        field = new Field();
        gameObjectFactory = new GameObjectFactory();
        gameObjects = GameObjectFactory.createWallLimits(field);
        collisiondetector = new CollisionDetector(gameObjects);
        player = new Player(new Position(50,50));

        collisiondetector.checkCollision(player);
    }

    public void start() throws InterruptedException {

        while(player.isAlive() || !door.isOpened()) {

            // Pause for a while
            Thread.sleep(delay);

            moveZombies();

        }
    }

    public void moveZombies(){

        for (GameObject zombie : gameObjects){

            if (zombie instanceof Zombie){

                Zombie zombie1 = (Zombie) zombie;
                zombie1.move();
                collisiondetector.checkCollision(zombie);
            }
        }
    }
}


