package org.academiadecodigo.gnunas.sketch.GameObject;

<<<<<<< HEAD
import org.academiadecodigo.gnunas.sketch.Direction;
=======
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
import org.academiadecodigo.gnunas.sketch.Field;
import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

<<<<<<< HEAD
public class Player implements KeyboardHandler, Movable {
=======
public class Player extends GameObject implements KeyboardHandler, Movable {
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409

    private boolean keyHolder;
    private boolean alive;
    private Position pos;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle player;
    private Keyboard keyboard;
<<<<<<< HEAD
    private KeyboardEvent keyboardEventMoveRight;
    private KeyboardEvent keyboardEventMoveLeft;
    private KeyboardEvent keyboardEventMoveUp;
    private KeyboardEvent keyboardEventMoveDown;
=======
    private KeyboardEvent keyboardEvent;
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
    private Field field;


    public Player(Field field){
        this.field = field;
        this.keyHolder = false;
        this.alive = true;
        this.pos = new Position(field.PADDING, field.height/2, field);
        this.player = new Rectangle(pos.getX(), pos.getY(), 10, 10);
        player.fill();
<<<<<<< HEAD

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
=======
        keyboard = new Keyboard(this);
        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

      //Insert position, graphic representation, alive = true etc...
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
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
<<<<<<< HEAD
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



=======
    public void move(){
        //Implement every type of movement
        int prevPos = pos.getX();
        pos.moveRight();
        player.translate((pos.getX() - prevPos), 0);
    }


>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //implement keys for movement

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
<<<<<<< HEAD
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
=======
            move();
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
        }
    }
}
