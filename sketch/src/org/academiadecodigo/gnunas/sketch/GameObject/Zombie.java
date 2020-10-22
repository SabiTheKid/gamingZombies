package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.Direction;
import org.academiadecodigo.gnunas.sketch.Field;
import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Zombie extends GameObject implements Movable, Collidable{
    private Direction direction;
    private Direction previousDirection;
    private int movesCounter = 0;
    private Picture ZombiePicture = new Picture(0,0,"zombie_2_down.png");
    int ZombiePictureHeight = ZombiePicture.getHeight();
    int ZombiePictureWidth = ZombiePicture.getWidth();
    private boolean canIMove;


    public Zombie(Position pos, Picture picture) {
        super(pos, picture);
    }

    @Override
    public void move(Direction direction) {
    }

    public Direction turn() {
        if (movesCounter < 25 && movesCounter != 0 && canIMove == true) {
            return direction;
        }
        direction = Direction.random();
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

        switch (direction) {
            case UP:
                getPicture().load("zombie_2_up.png");
                //getPos().moveUp();
                break;
            case DOWN:
                //getPos().moveDown();
                getPicture().load("zombie_2_down.png");
                break;
            case RIGHT:
                //getPos().moveRight(keyHolder);
                getPicture().load("zombie_2_right.png");
                break;
            case LEFT:
                //getPos().moveLeft();
                getPicture().load("zombie_2_left.png");
                break;
        }
        super.getPicture().translate(direction.getXDifference(), direction.getYDifference());
        getPos().move(direction);
        previousDirection = direction;
    }

    private boolean canTurn(Direction direction) {
        switch (direction) {
            case RIGHT:
                return getPos().getX()+ZombiePictureWidth + direction.getXDifference() < Field.width+Field.PADDING+Field.DEFAULT_PADDING;
            case LEFT:
                return getPos().getX() + direction.getXDifference() > Field.PADDING+Field.DEFAULT_PADDING;
            case UP:
                return getPos().getY() + direction.getYDifference() > Field.PADDING+Field.DEFAULT_PADDING;
            case DOWN:
                return getPos().getY()+ZombiePictureHeight + direction.getYDifference() < Field.height+Field.PADDING+Field.DEFAULT_PADDING;
            default:
                return false;
        }

    }
}
