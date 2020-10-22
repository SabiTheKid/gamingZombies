package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class StartMenu implements KeyboardHandler {


    private Picture background;
    private Rectangle cursor;
    private Picture playButton;
    private Picture quitButton;
    private int buttonX;
    private int buttonY;
    private int buttonPadding;
    private Keyboard keyboard;
    private KeyboardEvent moveUp;
    private KeyboardEvent moveDown;
    private KeyboardEvent select;
    private Game game;

    public StartMenu(Game game) {
        this.game = game;
        buttonX = Field.width - 300;
        buttonY = Field.height - 150;
        buttonPadding = 40;
        background = new Picture(Field.PADDING, Field.PADDING, "startMenuBackground.jpg");
        quitButton = new Picture(buttonX, buttonY, "quitButton.png");
        playButton = new Picture(buttonX, quitButton.getY() - buttonPadding - quitButton.getHeight(), "playButton.png");
        background.draw();
        cursor = new Rectangle(playButton.getX() - 10, playButton.getY() - 10, playButton.getWidth() + 20, playButton.getHeight() + 20);
        cursor.setColor(Color.WHITE);
        cursor.fill();
        playButton.draw();
        quitButton.draw();
        keyboard = new Keyboard(this);
        moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);
        moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown);
        select = new KeyboardEvent();
        select.setKey(KeyboardEvent.KEY_ENTER);
        select.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(select);

    }

    public void move(MenuDirection direction) {
        switch (direction) {
            case UP:
                if (cursor.getY() + 10 == playButton.getY()) {
                    return;
                }
                cursor.translate(0, -(buttonPadding + playButton.getHeight()));
                break;
            case DOWN:
                if (cursor.getY() + 10 == quitButton.getY()) {
                    return;
                }
                cursor.translate(0, buttonPadding + playButton.getHeight());
                break;
        }
    }

    public void delete() {
        background.delete();
        playButton.delete();
        quitButton.delete();
        cursor.delete();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent == moveUp) {
            move(MenuDirection.UP);
        }
        if (keyboardEvent == moveDown) {
            move(MenuDirection.DOWN);
        }
        if (keyboardEvent == select) {

            if ((cursor.getY() + 10) == playButton.getY()) {
                System.out.println(cursor.getY() + 10);
                System.out.println(playButton.getY());
                delete();
                game.setInMenu(false);
                return;
            }
            System.out.println(cursor.getY() + 10);
            System.out.println(playButton.getY());
            System.exit(0);


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
