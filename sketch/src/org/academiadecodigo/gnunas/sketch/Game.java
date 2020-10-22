package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class Game {

    private Field field;
    private CollisionDetector collisiondetector;
    private List<GameObject> gameObjects;
    private List<Zombie> zombieList;
    private Player player;
    private Level[] levels = Level.values();
    private int level = 0;
    private boolean inMenu;
    private StartMenu startMenu;
    private GameOverMenu gameOverMenu;
    private GameState gameState;
    private boolean inGameOverMenu;
    private Sound musicGame;
    private Sound musicMenu;


    public Game() {
        gameState = GameState.STARTMENU;
        inMenu = true;
        inGameOverMenu = false;
        musicGame = new Sound("/resources/Game playing sounds.wav");
        musicMenu = new Sound ("/resources/Zombie Music.wav");
    }

    public void init() {
        field = new Field();
        gameObjects = GameObjectFactory.createFixedGameObjects();
        zombieList = GameObjectFactory.createZombies(levels[level]);
        gameObjects.addAll(zombieList);
        collisiondetector = new CollisionDetector(gameObjects);
        gameObjects.add(new Key(GameObjectFactory.generatePositionForKeyAndZombies()));
        player = new Player(new Position(40, (field.getHeight() / 2)+Field.DEFAULT_PADDING));
    }


    public void start() {

        switch (gameState) {

            case GAMEOVERMENU:
                gameOverMenu();
                musicMenu.setLoop(20);

                while (inGameOverMenu) {

                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                musicMenu.stop();
                start();
                break;
            case STARTMENU:
                menu();
                musicMenu.setLoop(20);
                while (inMenu) {

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                musicMenu.stop();
                start();
                break;
            case PLAY:
                musicGame = new Sound("/resources/Game playing sounds.wav");
                musicGame.play(true);
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
                        musicGame.close();
                        deleteAllGraphics();
                        level = 0;
                        inGameOverMenu = true;
                        gameState = GameState.GAMEOVERMENU;
                        start();
                        break;
                    }
                    musicGame.close();
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
                    new Picture(32,32, "resources/Webp.png").draw();

                    break;
                }
        }
    }


    public void moveZombies() {

        for (Zombie zombie : zombieList) {

            zombie.move();
            collisiondetector.checkCollision(zombie);
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



