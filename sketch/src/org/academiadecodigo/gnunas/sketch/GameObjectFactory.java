package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.Door;
import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;
import org.academiadecodigo.gnunas.sketch.GameObject.Key;
import org.academiadecodigo.gnunas.sketch.GameObject.Zombie;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class GameObjectFactory {

    public static ArrayList<Zombie> createZombies(Level level) {
        ArrayList<Zombie> zombieList = new ArrayList<>();
        Position position = generatePositionForKeyAndZombies();
        for(int i = 0; i < level.getNumberOfZombies(); i++) {
            position = generatePositionForKeyAndZombies();
            zombieList.add(new Zombie(position, new Picture(position.getX(), position.getY(), "zombie_2_left.png")));
        }
        zombieList.add(new Zombie(generatePositionForKeyAndZombies(), new Picture(200, 200, "zombie_2_left.png")));
        return zombieList;
    }

    public static ArrayList<GameObject> createFixedGameObjects() {
        ArrayList<GameObject> gameFixedObjectsList = createObjectLimits();
        gameFixedObjectsList.add(new Key(generatePositionForKeyAndZombies()));
        return gameFixedObjectsList;
    }



    public static ArrayList<GameObject> createObjectLimits() {
        ArrayList<GameObject> gameObjectsList = new ArrayList<>();
        Picture wallPicture = new Picture(0,0,"wall_32.png");
        int padding = Field.PADDING;
        int wallHeight = wallPicture.getHeight();
        int wallWidth = wallPicture.getWidth();

        //Create left wall
        for(int y = 0; y < Field.height+wallHeight*2; y += wallHeight ) {
            if(y == Field.height/2){
                gameObjectsList.add(new Door(new Position(0,y), new Picture(0, y, "entrance_door.png")));
                continue;
            }
            gameObjectsList.add(new GameObject(new Position(0, y), new Picture(0, y, "wall_32.png")));
        }
        //Create right wall
        for(int y = 0; y < Field.height+wallHeight*2; y += wallHeight) {
            if(y == Field.height/2){
                gameObjectsList.add(new Door(new Position(Field.width+padding, y), new Picture(Field.width+padding, y, "exit_door.png")));
                continue;
            }
            gameObjectsList.add(new GameObject(new Position(Field.width+padding, y), new Picture(Field.width+padding, y,"wall_32.png" )));
        }
        //Create up wall
        for(int x = padding; x < Field.width+wallWidth; x += wallWidth ) {
            gameObjectsList.add(new GameObject(new Position(x, 0), new Picture(x, 0, "wall_32.png")));
        }
        //Create down wall
        for(int x = padding; x < Field.width+wallWidth; x += wallWidth ) {
            gameObjectsList.add(new GameObject(new Position(x, Field.height+padding), new Picture(x, Field.height+padding, "wall_32.png")));
        }
        return gameObjectsList;
    }

    public static ArrayList<GameObject> createWall() {
        return null;
    }

    public static Position generatePositionForKeyAndZombies() {
        int safeZone = 100;
        int randomYPosition = (int) (Math.random()*(Field.height-Field.PADDING)) + Field.PADDING;
        int randomXPosition = (int) (Math.random()*(Field.width-Field.PADDING-safeZone)) + Field.PADDING + safeZone;
        return new Position(randomXPosition, randomYPosition);
    }

    
}
