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
    private Level[] levels = Level.values();
    private int level = 0;
    private boolean inMenu;
    private StartMenu startMenu;
    private GameOverMenu gameOverMenu;
    private GameState gameState;
    private boolean inGameOverMenu;

    public Game() {
        gameState = GameState.STARTMENU;
        inMenu = true;
        inGameOverMenu = false;
    }

    public void init() {
        field = new Field();
        gameObjects = GameObjectFactory.createFixedGameObjects();
        zombieList = GameObjectFactory.createZombies(levels[level]);
        gameObjects.addAll(zombieList);
        collisiondetector = new CollisionDetector(gameObjects);
        player = new Player(new Position(40, (field.getHeight() / 2)));

    }


    public void start() {

        System.out.println(gameState);
        switch (gameState) {
            case GAMEOVERMENU:
                gameOverMenu();
                while (inGameOverMenu) {
                    System.out.println(""); //This sout is vital to the game, DO NOT DELETE!!!
                }
                System.out.println(gameState);
                start();
                break;
            case STARTMENU:
                menu();
                while (inMenu) {
                    System.out.println(""); //This sout is vital to the game, DO NOT DELETE!!!
                }
                System.out.println(gameState);
                start();
                break;
            case PLAY:

                init();

                while (player.isAlive()) {

                    while (!(player.isOpenedDoor()) && player.isAlive()) {

                        try {

                            Thread.sleep(levels[level].getDelay());
                        } catch (Exception ex) {

                            System.out.println(ex);
                        }

                        collisiondetector.checkCollision(player);

                        moveZombies();

                    }
                    if (!player.isAlive()) {

                        deleteAllGraphics();
                        level = 0;
                        inGameOverMenu = true;
                        gameState = GameState.GAMEOVERMENU;
                        start();
                        break;
                    }

                    player.stopPlayer();
                    level++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    deleteAllGraphics();
                    if (level < levels.length) {
                        start();
                    }
                    break;
                }


        }
    }
    //}


    public void moveZombies() {

        for (Zombie zombie : zombieList) {

            if (zombie instanceof Zombie) {

                Zombie zombie1 = (Zombie) zombie;
                zombie1.move();
                collisiondetector.checkCollision(zombie);
            }
        }
    }

    private void deleteAllGraphics() {
        player.getLanternView().delete();
        player.getPicture().delete();
        field.getMap().delete();
        for (GameObject gameObject : gameObjects) {
            gameObject.getPicture().delete();
        }
        for (Zombie zombie : zombieList) {
            zombie.getPicture().delete();
        }
    }

    public void menu() {
        startMenu = new StartMenu(this);
    }

    public void setInMenu(boolean inMenu) {
        this.inMenu = inMenu;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void gameOverMenu(){
        gameOverMenu = new GameOverMenu(this);
    }

    public void setInGameOverMenu(boolean inGameOverMenu) {
        this.inGameOverMenu = inGameOverMenu;
    }
    public boolean getInGameOverMenu(){
        return inGameOverMenu;
    }
    public boolean getInMenu(){
        return inMenu;
    }
}



