package org.academiadecodigo.gnunas.sketch.GameObject;

<<<<<<< HEAD
<<<<<<< HEAD
import org.academiadecodigo.gnunas.sketch.Direction;
=======
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
=======
import org.academiadecodigo.gnunas.sketch.Direction;
>>>>>>> master
import org.academiadecodigo.gnunas.sketch.Field;
import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

<<<<<<< HEAD
<<<<<<< HEAD
public class Player implements KeyboardHandler, Movable {
=======
public class Player extends GameObject implements KeyboardHandler, Movable {
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
=======
public class Player extends GameObject implements KeyboardHandler, Movable, Collidable {
>>>>>>> master

    private boolean keyHolder;
    private boolean alive;
    private Keyboard keyboard;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> master
    private KeyboardEvent keyboardEventMoveRight;
    private KeyboardEvent keyboardEventMoveLeft;
    private KeyboardEvent keyboardEventMoveUp;
    private KeyboardEvent keyboardEventMoveDown;
<<<<<<< HEAD
=======
    private KeyboardEvent keyboardEvent;
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
    private Field field;
=======
>>>>>>> master


    public Player(Position pos) {

        super(pos);
        this.keyHolder = false;
        this.alive = true;
<<<<<<< HEAD
        this.pos = new Position(field.PADDING, field.height/2, field);
        this.player = new Rectangle(pos.getX(), pos.getY(), 10, 10);
        player.fill();
<<<<<<< HEAD

=======
>>>>>>> master
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
<<<<<<< HEAD
=======
        keyboard = new Keyboard(this);
        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

      //Insert position, graphic representation, alive = true etc...
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
=======

        //Insert position, graphic representation, alive = true etc...
>>>>>>> master
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
<<<<<<< HEAD
<<<<<<< HEAD
    public void move(Direction direction){
=======
    public void move(Direction direction) {
>>>>>>> master
        //Implement every type of movement
        //Position previousPosition = pos;
        int prevPosX = super.getPos().getX();
        int prevPosY = super.getPos().getY();
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
        //player.translate(pos.getX()-previousPosition.getX(), pos.getY()-previousPosition.getY());
<<<<<<< HEAD
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
=======
        super.getPicture().translate((super.getPos().getX() - prevPosX), (super.getPos().getY() - prevPosY));
    }


>>>>>>> master
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //implement keys for movement

<<<<<<< HEAD
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
<<<<<<< HEAD
=======
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
>>>>>>> master
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
<<<<<<< HEAD
=======
            move();
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
=======
        }
    }

    @Override
    public void collided(GameObject object) {

        if (object instanceof Key) {
            Key key = (Key) object;
            setKeyHolder(true);
            key.removeKey();
>>>>>>> master
        }
    }
}
