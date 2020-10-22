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
        Position position;
        for(int i = 0; i < level.getNumberOfZombies(); i++) {
            position = generatePositionForKeyAndZombies();
            zombieList.add(new Zombie(position, new Picture(position.getX(), position.getY(), "resources/zombie_2_left.png")));
        }
        return zombieList;
    }

    public static ArrayList<GameObject> createFixedGameObjects() {
        ArrayList<GameObject> gameFixedObjectsList = createObjectLimits();
        gameFixedObjectsList.add(new Key(generatePositionForKeyAndZombies()));
        return gameFixedObjectsList;
    }



    public static ArrayList<GameObject> createObjectLimits() {
        ArrayList<GameObject> gameObjectsList = new ArrayList<>();
        Picture wallPicture = new Picture(0,0,"resources/wall_32.png");
        int padding = Field.PADDING;
        int defaultPadding = Field.DEFAULT_PADDING;
        int wallHeight = wallPicture.getHeight();
        int wallWidth = wallPicture.getWidth();

        //Create left wall
        for(int y = defaultPadding; y < defaultPadding+Field.height+wallHeight*2; y += wallHeight ) {
            if(y == Field.height/2+defaultPadding){
                gameObjectsList.add(new Door(new Position(defaultPadding,y), new Picture(defaultPadding, y, "resources/entrance_door.png")));
                continue;
            }
            new GameObject(new Position(defaultPadding, y), new Picture(defaultPadding, y, "resources/wall_32.png"));
        }
        //Create right wall
        for(int y = defaultPadding; y < defaultPadding+Field.height+wallHeight*2; y += wallHeight) {
            if(y == Field.height/2+defaultPadding){
                gameObjectsList.add(new Door(new Position(Field.width+padding+defaultPadding, y), new Picture(Field.width+padding+defaultPadding, y, "resources/exit_door.png")));
                continue;
            }
            new GameObject(new Position(defaultPadding+Field.width+padding, y), new Picture(defaultPadding+Field.width+padding, y,"resources/wall_32.png" ));
        }
        //Create up wall
        for(int x = defaultPadding+padding; x < defaultPadding+Field.width+wallWidth; x += wallWidth ) {
            new GameObject(new Position(x, defaultPadding), new Picture(x, defaultPadding, "resources/wall_32.png"));
        }
        //Create down wall
        for(int x = padding+defaultPadding; x < defaultPadding+Field.width+wallWidth; x += wallWidth ) {
            new GameObject(new Position(x, defaultPadding+Field.height+padding), new Picture(x, defaultPadding+Field.height+padding, "resources/wall_32.png"));
        }
        return gameObjectsList;
    }

    public static ArrayList<GameObject> createWall() {
        return null;
    }

    public static Position generatePositionForKeyAndZombies() {
        int safeZone = 100;
        int randomYPosition = (int) (Math.random()*(Field.height-Field.PADDING+Field.DEFAULT_PADDING)) + Field.PADDING+Field.DEFAULT_PADDING;
        int randomXPosition = (int) (Math.random()*(Field.width-Field.PADDING-safeZone+Field.DEFAULT_PADDING)) + Field.PADDING + safeZone + Field.DEFAULT_PADDING;
        return new Position(randomXPosition, randomYPosition);
    }
}
