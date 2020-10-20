package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.Direction;
import org.academiadecodigo.gnunas.sketch.Field;
import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Zombie extends GameObject implements Movable, Collidable{
    private ZombieDirection direction;
    private ZombieDirection previousDirection;
    private int movesCounter = 0;
    private Picture ZombiePicture = new Picture(0,0,"wall_32.png");
    int ZombiePictureHeight = ZombiePicture.getHeight();
    int ZombiePictureWidth = ZombiePicture.getWidth();
    private boolean keyHolder = false;
    private boolean canIMove;


    public Zombie(Position pos, Picture picture) {
        super(pos, picture);
    }

    @Override
    public void move(Direction direction) {
    }

    public ZombieDirection turn() {
        if (movesCounter < 50 && movesCounter != 0 && canIMove == true) {
            return direction;
        }
        direction = ZombieDirection.random();
        if (!canTurn(direction)) {
            turn();
        }
        if (direction.isOpposite(previousDirection)) {
            turn();
        }
        movesCounter = 0;

        return direction;
    }


    @Override
    public void move() {

        direction = turn();



        if (!canTurn(direction)) {
            canIMove = false;
            turn();
        }
        canIMove = true;
        movesCounter++;
        /*
        movesCounter++;
        switch (direction) {
            case UP:
                //getPos().moveUp();
                break;
            case DOWN:
                //getPos().moveDown();
                break;
            case RIGHT:
                //getPos().moveRight(keyHolder);
                break;
            case LEFT:
                //getPos().moveLeft();
                break;
        }*/
        //super.getPicture().translate(10,0);
        super.getPicture().translate(direction.getXDifference(), direction.getYDifference());
        getPos().move(direction);
        previousDirection = direction;
    }

    private boolean canTurn(ZombieDirection direction) {
        switch (direction) {
            case RIGHT:
                return getPos().getX()+ZombiePictureWidth + direction.getXDifference() < Field.width+Field.PADDING;
            case LEFT:
                return getPos().getX() + direction.getXDifference() > Field.PADDING;
            case UP:
                return getPos().getY() + direction.getYDifference() > Field.PADDING;
            case DOWN:
                return getPos().getY()+ZombiePictureHeight + direction.getYDifference() < Field.height+Field.PADDING;
            default:
                return false;
        }

    }
}
