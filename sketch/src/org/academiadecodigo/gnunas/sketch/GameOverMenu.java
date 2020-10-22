package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOverMenu implements KeyboardHandler {


    private Picture background;
    private Picture foreground;
    private Rectangle cursor;
    private Picture tryAgainButton;
    private Picture quitButton;
    private Picture gameOverLettering;
    private int buttonX;
    private int buttonY;
    private int buttonPadding;
    private Keyboard keyboard;
    private KeyboardEvent moveUp;
    private KeyboardEvent moveDown;
    private KeyboardEvent select;
    private Game game;

    public GameOverMenu(Game game){
        this.game = game;
        buttonX = Field.width/2-110;
        buttonY = Field.height-300;
        buttonPadding = 40;
        background = new Picture(Field.PADDING,Field.PADDING, "startMenuBackground.jpg");
        foreground = new Picture(Field.PADDING, Field.PADDING, "gameOverForeground.png");
        gameOverLettering = new Picture(Field.PADDING+(Field.width/2 - 315), Field.PADDING + buttonPadding*3, "gameOverButton.png");
        tryAgainButton = new Picture(Field.PADDING+(Field.width/2 - 190), gameOverLettering.getMaxY() + buttonPadding,"tryAgainButton.png");
        quitButton = new Picture(Field.PADDING+(Field.width/2 - 105),tryAgainButton.getMaxY()+buttonPadding, "quitButton.png");
        background.draw();
        foreground.draw();
        cursor = new Rectangle(tryAgainButton.getX()-10, tryAgainButton.getY()-10, tryAgainButton.getWidth()+20, tryAgainButton.getHeight()+20);
        cursor.setColor(Color.WHITE);
        cursor.fill();
        tryAgainButton.draw();
        quitButton.draw();
        gameOverLettering.draw();
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

    public void move(Direction direction){
        switch (direction){
            case UP:
                if(cursor.getY()+10 == tryAgainButton.getY()){
                    return;
                }
                cursor.delete();
                cursor = new Rectangle(tryAgainButton.getX()-10, tryAgainButton.getY()-10, tryAgainButton.getWidth()+20, tryAgainButton.getHeight()+20);
                cursor.setColor(Color.WHITE);
                cursor.fill();
                tryAgainButton.delete();
                tryAgainButton.draw();
                break;
            case DOWN:
                if(cursor.getY()+10 == quitButton.getY()){
                    return;
                }
                cursor.delete();
                cursor = new Rectangle(quitButton.getX()-10, quitButton.getY()-10, quitButton.getWidth()+20, quitButton.getHeight()+20);
                cursor.setColor(Color.WHITE);
                cursor.fill();
                quitButton.delete();
                quitButton.draw();
        }
    }

    public void delete(){
        foreground.delete();
        background.delete();
        tryAgainButton.delete();
        quitButton.delete();
        cursor.delete();
        gameOverLettering.delete();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent == moveUp){
            move(Direction.UP);
        }
        if (keyboardEvent == moveDown){
            move(Direction.DOWN);
        }
        if (keyboardEvent == select){
            System.out.println(cursor.getY()+10);
            System.out.println(tryAgainButton.getY());
            if ((cursor.getY()+10) == tryAgainButton.getY()){
                delete();
                game.setInMenu(false);
            }
            if ((cursor.getY()+10) == quitButton.getY()) {
                System.exit(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
