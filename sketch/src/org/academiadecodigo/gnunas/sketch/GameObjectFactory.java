package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;

public class GameObjectFactory {

    public static GameObject createWallLimits() {
        int padding = Field.PADDING;
        int wallHeight;
        int wallWidth;

        for(int y = Field.PADDING; y < Field.height; y += wallHeight ) {
            return new GameObject(new Position(Field.PADDING, y, /*No Field*/));
        }
        for(int y = Field.PADDING; y < Field.height; y += wallHeight) {
            return new GameObject(new Position((Field.width, y, /*No Field*/));
        }
        for(int x = Field.PADDING; x < Field.height; x += wallWidth ) {
            return new GameObject(new Position(Field.PADDING, y, /*No Field*/));
        }
        for(int x = Field.PADDING; x < Field.height; x += wallWidth ) {
            return new GameObject(new Position(Field.PADDING, y, /*No Field*/));
        }
    }


    // Implements the logic of object's construction( for now only walls(Game Objects)---->limits of field, and player)
}
