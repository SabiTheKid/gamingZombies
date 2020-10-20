package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;
import org.academiadecodigo.gnunas.sketch.GameObject.Zombie;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.LinkedList;

public class GameObjectFactory {

    public static ArrayList<Zombie> createZombies() {
        ArrayList<Zombie> zombieList = new ArrayList<>();
        zombieList.add(new Zombie(new Position(200, 200), new Picture(200, 200, "wall_32.png")));
        return zombieList;
    }

    public static ArrayList<GameObject> createAllGameObjects() {
        ArrayList<GameObject> gameObjectsList = createWallLimits();
        gameObjectsList.add(new Zombie(new Position(100, 100), new Picture(100, 100, "wall_32.png")));
        return gameObjectsList;
    }


    public static ArrayList<GameObject> createWallLimits() {
        ArrayList<GameObject> gameObjectsList = new ArrayList<>();
        Picture wallPicture = new Picture(0,0,"wall_32.png");
        int padding = Field.PADDING;
        int wallHeight = wallPicture.getHeight();
        int wallWidth = wallPicture.getWidth();

        //Create left wall
        for(int y = 0; y < Field.height+wallHeight*2; y += wallHeight ) {
            if(y == Field.height/2){
                continue;
            }
            gameObjectsList.add(new GameObject(new Position(0, y), new Picture(0, y, "wall_32.png")));
        }
        //Create right wall
        for(int y = 0; y < Field.height+wallHeight*2; y += wallHeight) {
            if(y == Field.height/2){
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

    
}
