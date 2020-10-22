package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class Game {

    private Field field;
    private CollisionDetector collisiondetector;
    private List<GameObject> gameObjects;
    private GameObjectFactory gameObjectFactory = new GameObjectFactory();
    private List<Zombie> zombieList;
    private Player player;
    private boolean inMenu;

    public Game(){

    }

    public void init(){
        field = new Field();
    }
    public void initLevelOne() throws InterruptedException {

        gameObjects = GameObjectFactory.createFixedGameObjects();
        zombieList = GameObjectFactory.createZombies(Level.ONE);
        collisiondetector = new CollisionDetector(gameObjects);
        player = new Player(new Position(50, (field.getHeight()/2)));
        start(Level.ONE.getDelay());
    }
    public void initLevelTwo() throws InterruptedException {

        gameObjects = GameObjectFactory.createFixedGameObjects();
        zombieList = GameObjectFactory.createZombies(Level.TWO);
        collisiondetector = new CollisionDetector(gameObjects);
        player = new Player(new Position(50, (field.getHeight()/2)));
        start(Level.TWO.getDelay());
    }

    public void start(int delay) throws InterruptedException {
        menu();

        while (!inMenu) {
            while (player.isAlive()/* || !door.isOpened()*/) {

                // Pause for a while
                Thread.sleep(delay);

                collisiondetector.checkCollision(player);

                moveZombies();

            }

        }
        throw new InterruptedException("morreu");
    }

    public void moveZombies(){

        for (Zombie zombie : zombieList){

            if (zombie instanceof Zombie){

                Zombie zombie1 = (Zombie) zombie;
                zombie1.move();
                collisiondetector.checkCollision(zombie);
            }
        }
    }
    public void setInMenu(Boolean inMenu){
        this.inMenu = inMenu;
    }

    public void menu(){
        inMenu = true;
        StartMenu startMenu = new StartMenu(this);
    }
    public void gameOverMenu(){
        GameOverMenu gameOverMenu = new GameOverMenu(this);
        inMenu = true;
    }
}


