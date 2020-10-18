package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.Direction;
import org.academiadecodigo.gnunas.sketch.Field;
import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler, Movable {

    private boolean keyHolder;
    private boolean alive;
    private Position pos;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle player;
    private Keyboard keyboard;
    private KeyboardEvent keyboardEventMoveRight;
    private KeyboardEvent keyboardEventMoveLeft;
    private KeyboardEvent keyboardEventMoveUp;
    private KeyboardEvent keyboardEventMoveDown;
    private Field field;


    public Player(Field field){
        this.field = field;
        this.keyHolder = false;
        this.alive = true;
        this.pos = new Position(field.PADDING, field.height/2, field);
        this.player = new Rectangle(pos.getX(), pos.getY(), 10, 10);
        player.fill();

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
    }

    public boolean isKeyHolder() {
        return keyHolder;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setKeyHolder(boolean keyHolder){
        this.keyHolder = keyHolder;

    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public void move(Direction direction){
        //Implement every type of movement
        //Position previousPosition = pos;
        int prevPosX = pos.getX();
        int prevPosY = pos.getY();
        switch (direction){
            case RIGHT:
                pos.moveRight();
                break;
            case LEFT:
                pos.moveLeft();
                break;
            case UP:
                pos.moveUp();
                break;
            case DOWN:
                pos.moveDown();
                break;
        }
        //player.translate(pos.getX()-previousPosition.getX(), pos.getY()-previousPosition.getY());
        player.translate((pos.getX() - prevPosX), (pos.getY() - prevPosY));
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //implement keys for movement

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            move(Direction.RIGHT);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            move(Direction.LEFT);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            move(Direction.UP);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            move(Direction.DOWN);
        }
    }
}
