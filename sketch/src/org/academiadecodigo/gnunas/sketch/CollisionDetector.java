package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;

import java.util.List;

public class CollisionDetector {

    //Implements the logic for analysing the collisions between objects( Player and Walls)

    // Have an array with all the gameObjects
    private List<GameObject> objectsGame;

    public CollisionDetector(List<GameObject> objectsGame) {
        this.objectsGame = objectsGame;
    }


    public void checkCollision(GameObject object) {

        for (GameObject obj : objectsGame) {

            if (obj == object) {
                continue;
            }

            int rightLimitX = object.getPos().getX() + object.getPicture().getWidth();
            int leftLimitX = object.getPos().getX();
            int lowerLimitY = object.getPos().getY() + object.getPicture().getHeight();
            int upperLimitY = object.getPos().getY();
            int objLeftLimitX = obj.getPos().getX();
            int objRightLimitX = obj.getPos().getX() + obj.getPicture().getWidth();
            int objLowerLimitY = obj.getPos().getY() + obj.getPicture().getHeight();
            int objUpperLimitY = obj.getPos().getY();

            if (rightLimitX >= objLeftLimitX && leftLimitX <= objRightLimitX) {

                if (lowerLimitY >= objUpperLimitY && upperLimitY <= objLowerLimitY) {
                    object.collided(obj);
                }
            }

            //if (obj.getPos().equals(object.getPos())){
            // obj.collided(object);
        }
    }
}

