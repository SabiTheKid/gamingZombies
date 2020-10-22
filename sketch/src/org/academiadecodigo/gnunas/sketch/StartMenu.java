package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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
    private Picture arrows;
    private Picture instructions;
    private Picture title;

    public StartMenu(Game game){
        this.game = game;
        game.setInMenu(true);
        buttonX = Field.width-300;
        buttonY = Field.height-150;
        buttonPadding = 40;
        background = new Picture(0,0, "resources/startMenuBackground4.jpg");
        quitButton = new Picture(buttonX,buttonY, "resources/quitButton.png");
        playButton = new Picture(buttonX, quitButton.getY()-buttonPadding-quitButton.getHeight(),"resources/playButton.png");
        arrows = new Picture(100,330,"resources/instructionsArrows.png");
        instructions = new Picture(150,620,"resources/instructionsSentence.png");
        title = new Picture(500, 30, "resources/gameLogo.png");
        background.draw();
        arrows.draw();
        instructions.draw();
        title.draw();
        cursor = new Rectangle(playButton.getX()-10, playButton.getY()-10, playButton.getWidth()+20, playButton.getHeight()+20);
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

    public void move(Direction direction){
        switch (direction){
            case UP:
                if(cursor.getY()+10 == playButton.getY()){
                    return;
                }
                cursor.translate(0, -(buttonPadding + playButton.getHeight()));
                break;
            case DOWN:
                if(cursor.getY()+10 == quitButton.getY()){
                    return;
                }
                cursor.translate(0, buttonPadding + playButton.getHeight());
        }
    }

    public void delete(){
        instructions.delete();
        arrows.delete();
        background.delete();
        playButton.delete();
        quitButton.delete();
        cursor.delete();
        title.delete();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (!game.getInMenu()){
            return;
    }
        if (keyboardEvent == moveUp) {
                move(Direction.UP);
            }
            if (keyboardEvent == moveDown) {
                move(Direction.DOWN);
            }
            if (keyboardEvent == select) {

                if ((cursor.getY() + 10) == playButton.getY()) {
                    delete();
                    game.setGameState(GameState.PLAY);
                    game.setInMenu(false);

                }
                if ((cursor.getY() + 10) == quitButton.getY()) {
                    exit();
                }
            }
        }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void exit(){
        System.exit(0);
    }
}
