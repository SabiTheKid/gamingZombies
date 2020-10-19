package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.LinkedList;

public class GameObjectFactory {


    public static ArrayList<GameObject> createWallLimits(Field field) {
        ArrayList<GameObject> gameObjectsList = new ArrayList<>();
        Picture wallPicture = new Picture(0,0,"wall_32.png");
        int padding = field.PADDING;
        int wallHeight = wallPicture.getHeight();
        int wallWidth = wallPicture.getWidth();

        //Create left wall
        for(int y = 0; y < field.height+wallHeight*2; y += wallHeight ) {
            if(y == field.height/2){
                continue;
            }
            gameObjectsList.add(new GameObject(new Position(0, y), new Picture(0, y, "wall_32.png")));
        }
        //Create right wall
        for(int y = 0; y < field.height+wallHeight*2; y += wallHeight) {
            if(y == field.height/2){
                continue;
            }
            gameObjectsList.add(new GameObject(new Position(field.width+padding, y), new Picture(field.width+padding, y,"wall_32.png" )));
        }
        //Create up wall
        for(int x = padding; x < field.width+wallWidth; x += wallWidth ) {
            gameObjectsList.add(new GameObject(new Position(x, 0), new Picture(x, 0, "wall_32.png")));
        }
        //Create down wall
        for(int x = padding; x < field.width+wallWidth; x += wallWidth ) {
            gameObjectsList.add(new GameObject(new Position(x, field.height+padding), new Picture(x, field.height+padding, "wall_32.png")));
        }
        return gameObjectsList;
    }

    public static ArrayList<GameObject> createWall() {
        return null;
    }

    
}
