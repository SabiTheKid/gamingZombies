package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.CollideFace;
import org.academiadecodigo.gnunas.sketch.Direction;
import org.academiadecodigo.gnunas.sketch.Field;
import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends GameObject implements KeyboardHandler, Movable, Collidable {

    private boolean hittedWall;
    private boolean keyHolder;
    private boolean alive;
    private Keyboard keyboard;
    private KeyboardEvent keyboardEventMoveRight;
    private KeyboardEvent keyboardEventMoveLeft;
    private KeyboardEvent keyboardEventMoveUp;
    private KeyboardEvent keyboardEventMoveDown;
    private int velocity;


    public Player(Position pos) {

        super(pos,new Picture(pos.getX(), pos.getY(), "player_still_up.png"));
        this.hittedWall = false;
        this.keyHolder = false;
        this.alive = true;
        this.velocity = 5;
        keyboard = new Keyboard(this);

        keyboardEventMoveRight = new KeyboardEvent();
        keyboardEventMoveRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventMoveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventMoveRight);

        keyboardEventMoveLeft = new KeyboardEvent();
        keyboardEventMoveLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventMoveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventMoveLeft);

        keyboardEventMoveUp = new KeyboardEvent();
        keyboardEventMoveUp.setKey(KeyboardEvent.KEY_UP);
        keyboardEventMoveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventMoveUp);

        keyboardEventMoveDown = new KeyboardEvent();
        keyboardEventMoveDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEventMoveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventMoveDown);

        //Insert position, graphic representation, alive = true etc...

        //Insert position, graphic representation, alive = true etc...
    }

    public boolean isKeyHolder() {
        return keyHolder;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setKeyHolder(boolean keyHolder) {
        this.keyHolder = keyHolder;

    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public void move(Direction direction) {
        //Implement every type of movement
        //Position previousPosition = pos;
        int prevPosX = super.getPos().getX();
        int prevPosY = super.getPos().getY();
        for (int i = 0; i < velocity; i++) {
            switch (direction) {
                case RIGHT:
                    super.getPos().moveRight();
                    break;
                case LEFT:
                    super.getPos().moveLeft();
                    break;
                case UP:
                    super.getPos().moveUp();
                    break;
                case DOWN:
                    super.getPos().moveDown();
                    break;
            }
        }

        //player.translate(pos.getX()-previousPosition.getX(), pos.getY()-previousPosition.getY());
        super.getPicture().translate((super.getPos().getX() - prevPosX), (super.getPos().getY() - prevPosY));
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //implement keys for movement

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            move(Direction.RIGHT);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            move(Direction.LEFT);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            move(Direction.UP);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            move(Direction.DOWN);
        }
    }

    @Override
    public void collided(GameObject object) {

        if (object instanceof Key) {
            Key key = (Key) object;
            keyHolder = true;
            key.removeKey();
        }

        hittedWall = true;

        /*int rightLimitX = getPos().getX() + picture.getWidth();
        int leftLimitX = getPos().getX();
        int lowerLimitY = getPos().getY() + picture.getHeight();
        int upperLimitY = getPos().getY();
        int objLeftLimitX = object1.getPos().getX();
        int objRightLimitX = object1.getPos().getX() + object1.getPicture().getWidth();
        int objLowerLimitY = object1.getPos().getY() + object1.getPicture().getHeight();
        int objUpperLimitY = object1.getPos().getY();

        if(rightLimitX >= objLeftLimitX) {
            return CollideFace.RIGHT;
        }
        if(leftLimitX <= objRightLimitX) {
            return CollideFace.LEFT;
        }
        if(upperLimitY <= objLowerLimitY) {
            return CollideFace.UP;
        }
        if(lowerLimitY >= objUpperLimitY) {
            return CollideFace.DOWN;
        }

        int rightLimitX = getPos().getX() + getPicture().getWidth();
        int leftLimitX = getPos().getX();
        int lowerLimitY = getPos().getY() + getPicture().getHeight();
        int upperLimitY = getPos().getY();
        int objLeftLimitX = object.getPos().getX();
        int objRightLimitX = object.getPos().getX() + object.getPicture().getWidth();
        int objLowerLimitY = object.getPos().getY() + object.getPicture().getHeight();
        int objUpperLimitY = object.getPos().getY();

        if (rightLimitX >= objLeftLimitX) {
            int difference = rightLimitX - objLeftLimitX;
            for (int i = 0; i < difference; i++){
                getPos().moveLeft();
            }
            getPicture().translate(-difference, 0);
        }

        if (leftLimitX <= objRightLimitX) {
            int difference = leftLimitX - objRightLimitX;
            for (int i = 0; i < difference; i++){
                getPos().moveRight();
            }
            getPicture().translate(difference, 0);
        }

        if (upperLimitY <= objLowerLimitY) {
            int difference = objLowerLimitY - upperLimitY;
            for (int i = 0; i < difference; i++){
                getPos().moveDown();
            }
            getPicture().translate(0, difference);
        }

        if (lowerLimitY >= objUpperLimitY) {
            int difference = lowerLimitY - objUpperLimitY;
            for (int i = 0; i < difference; i++){
                getPos().moveUp();
            }
            getPicture().translate(0, -difference);
        }
    }

    public CollideFace hitWall(){
        hittedWall = true;
        int rightLimitX = getPos().getX() + picture.getWidth();
        int leftLimitX = getPos().getX();
        int lowerLimitY = getPos().getY() + picture.getHeight();
        int upperLimitY = getPos().getY();
        int objLeftLimitX = object1.getPos().getX();
        int objRightLimitX = object1.getPos().getX() + object1.getPicture().getWidth();
        int objLowerLimitY = object1.getPos().getY() + object1.getPicture().getHeight();
        int objUpperLimitY = object1.getPos().getY();

        if(rightLimitX >= objLeftLimitX) {
            return CollideFace.RIGHT;
        }
        if(leftLimitX <= objRightLimitX) {
            return CollideFace.LEFT;
        }
        if(upperLimitY <= objLowerLimitY) {
            return CollideFace.UP;
        }
        if(lowerLimitY >= objUpperLimitY) {
            return CollideFace.DOWN;
        }
*/

    }
}
