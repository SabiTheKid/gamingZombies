package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;

import java.util.List;

public class CollisionDetector {
    private final int COLLISION_MARGIN = 3;


    private List<GameObject> objectsGame;

    public CollisionDetector(List<GameObject> objectsGame) {
        this.objectsGame = objectsGame;
    }


    public void checkCollision(GameObject object) {

        for (GameObject obj : objectsGame) {

            if (obj == object) {
                continue;
            }

            int rightLimitX = object.getPos().getX() + object.getPicture().getWidth() - COLLISION_MARGIN;
            int leftLimitX = object.getPos().getX() + COLLISION_MARGIN;
            int lowerLimitY = object.getPos().getY() + object.getPicture().getHeight() - COLLISION_MARGIN;
            int upperLimitY = object.getPos().getY() + COLLISION_MARGIN;
            int objLeftLimitX = obj.getPos().getX() + COLLISION_MARGIN;
            int objRightLimitX = obj.getPos().getX() + obj.getPicture().getWidth() - COLLISION_MARGIN;
            int objLowerLimitY = obj.getPos().getY() + obj.getPicture().getHeight() - COLLISION_MARGIN;
            int objUpperLimitY = obj.getPos().getY() + COLLISION_MARGIN;

            if (rightLimitX >= objLeftLimitX && leftLimitX <= objRightLimitX) {

                if (lowerLimitY >= objUpperLimitY && upperLimitY <= objLowerLimitY) {
                    object.collided(obj);
                }
            }

        }
    }
}

