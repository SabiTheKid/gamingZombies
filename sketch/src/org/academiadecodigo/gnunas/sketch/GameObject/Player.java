package org.academiadecodigo.gnunas.sketch.GameObject;

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
    private KeyboardEvent keyboardEvent;
    private Field field;


    public Player(Field field){
        this.field = field;
        this.keyHolder = false;
        this.alive = true;
        this.pos = new Position(field.PADDING, field.height/2);
        this.player = new Rectangle(pos.getX(), pos.getY(), 10, 10);
        player.fill();
        keyboard = new Keyboard(this);
        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

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
    public void move(){
        //Implement every type of movement
        int prevPos = pos.getX();
        pos.moveRight();
        player.translate((pos.getX() - prevPos), 0);
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        //implement keys for movement

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            move();
        }
    }
}
