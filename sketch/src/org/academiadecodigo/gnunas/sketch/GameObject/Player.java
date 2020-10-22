package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.Direction;
import org.academiadecodigo.gnunas.sketch.Field;
import org.academiadecodigo.gnunas.sketch.LanternView;
import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends GameObject implements KeyboardHandler, Movable, Collidable {

    private int velocity = 2;
    private boolean keyHolder;
    private boolean alive;
    private Keyboard keyboard;
    private KeyboardEvent keyboardEventMoveRight;
    private KeyboardEvent keyboardEventMoveLeft;
    private KeyboardEvent keyboardEventMoveUp;
    private KeyboardEvent keyboardEventMoveDown;
    private boolean paralyzed;
    private LanternView lanternView;
    private boolean openedDoor;

    public Player(Position pos) {

        super(pos,new Picture(pos.getX(), pos.getY(), "player_right.png"));
        this.keyHolder = false;
        this.alive = true;
        lanternView = new LanternView(pos.getX(),pos.getY());

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
    public void move() {

    }

    public boolean isOpenedDoor() {
        return openedDoor;
    }

    public LanternView getLanternView() {
        return lanternView;
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
                    super.getPos().moveRight(keyHolder, lanternView);
                    super.getPicture().load("player_right.png");
                    break;
                case LEFT:
                    super.getPos().moveLeft(lanternView);
                    super.getPicture().load("player_left.png");
                    break;
                case UP:
                    super.getPos().moveUp(lanternView);
                    super.getPicture().load("player_up.png");
                    break;
                case DOWN:
                    super.getPos().moveDown(lanternView);
                    super.getPicture().load("player_down.png");
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
        if (paralyzed) {
            return;
        }

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
        if (object instanceof Zombie){
            setAlive(false);
        }
        if (object instanceof Door && keyHolder) {
            Door door = (Door) object;
            door.openDoor();
            if(super.getPos().getX()>Field.width+17) {
                openedDoor = true;
            }
        }
    }

    public void stopPlayer(){
        paralyzed = true;

    }
}
