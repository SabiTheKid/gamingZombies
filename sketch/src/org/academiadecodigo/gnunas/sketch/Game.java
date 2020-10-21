package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class Game {

    private Field field;
    private CollisionDetector collisiondetector;
    private List<GameObject> gameObjects;
    private GameObjectFactory gameObjectFactory;
    private List<Zombie> zombieList;
    private int delay;
    private Player player;
    private Door door;

    public Game(int delay){
        this.delay = delay;
    }

    public void init(){
        field = new Field();
        gameObjectFactory = new GameObjectFactory();
        gameObjects = GameObjectFactory.createAllGameObjects();
        collisiondetector = new CollisionDetector(gameObjects);
        player = new Player(new Position(50, (field.getHeight()/2)));
        Key key = new Key(new Position(500, 500));
        gameObjects.add(key);
    }

    public void start() {


        // falta a condiçao de a porta estar fechada
        while(player.isAlive() || (player.isOpenedDoor())) {

            //Pause for a while

            try{
                Thread.sleep(delay);
            } catch (Exception ex){
                System.out.println(ex);
            }

            collisiondetector.checkCollision(player);

            moveZombies();

        }

        player.stopPlayer();
        field.getMap().load("game_field");
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


