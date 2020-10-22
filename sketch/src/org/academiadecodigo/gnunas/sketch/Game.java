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
    private Level[] levels = Level.values();
    private int level = 0;

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
        start();
    }
    public void initLevelTwo() throws InterruptedException {

        gameObjects = GameObjectFactory.createFixedGameObjects();
        zombieList = GameObjectFactory.createZombies(levels[level]);
        gameObjects.addAll(zombieList);
        collisiondetector = new CollisionDetector(gameObjects);
        player = new Player(new Position(40, (field.getHeight()/2)));
    }
    public void start() {
        menu();
        init();

        while (player.isAlive()) {

            while (!(player.isOpenedDoor()) && player.isAlive()){

                try {

                    Thread.sleep(levels[level].getDelay());
                } catch (Exception ex) {

                    System.out.println(ex);
                }

                collisiondetector.checkCollision(player);

                moveZombies();

            }
            if(!player.isAlive()){
                new Picture(0,0,"floor_bg.png").draw();
                deleteAllGraphics();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Insert something to go back to initial menu
                break;
            }
            //Player abre a porta e da ordem para começar novo nivel
            player.stopPlayer();
            level++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            deleteAllGraphics();
            //o init recebe um numero do lvl para criar um determinado lvl, de forma crescente
            if (level < levels.length){
                start();
            }
            break;
        }
        player.stopPlayer();
        new Picture(0,0,"floor_bg.png").draw();
        // depois de parar o jogador , mostra-se no screen Parabens;
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
    private void deleteAllGraphics() {
        player.getPicture().delete();
        field.getMap().delete();
        for(GameObject gameObject: gameObjects){
            gameObject.getPicture().delete();
        }
        for(Zombie zombie: zombieList){
            zombie.getPicture().delete();
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


