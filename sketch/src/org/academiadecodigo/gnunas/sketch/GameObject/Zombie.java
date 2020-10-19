package org.academiadecodigo.gnunas.sketch.GameObject;

import org.academiadecodigo.gnunas.sketch.Direction;
import org.academiadecodigo.gnunas.sketch.Field;
import org.academiadecodigo.gnunas.sketch.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Zombie extends GameObject implements Movable, Collidable{
    private ZombieDirection direction;
    private int moves = 0;
    private Picture ZombiePicture = new Picture(0,0,"wall_32.png");
    int ZombiePictureHeight = ZombiePicture.getHeight();
    int ZombiePictureWidth = ZombiePicture.getWidth();


    public Zombie(Position pos, Picture picture) {
        super(pos, picture);
    }

    @Override
    public void move(Direction direction) {
    }
    public ZombieDirection turn() {
        direction = ZombieDirection.random();
        return direction.isOpposite(direction) ? turn() : direction;
    }


    @Override
    public void move() {
        /*if (moves % getSpeed() == 0) {
            direction = turn();
        }*/

        moves++;

        if (!canTurn(direction)) {
            return;
        }
        switch (direction) {
            case UP:
                getPos().moveUp();
                return;
            case DOWN:
                getPos().moveDown();
                return;
            case RIGHT:
                getPos().moveRight();
                return;
            case LEFT:
                getPos().moveLeft();
                return;
        }
    }

    private boolean canTurn(ZombieDirection direction) {
        switch (direction) {
            case RIGHT:
                return getPos().getX()+ZombiePictureWidth + direction.getColumnDifference() < Field.width;
                case LEFT:
                    return getPos().getX() + direction.getColumnDifference() >= Field.PADDING;
                    case UP:
                    return getPos().getY() + direction.getRowDifference() >= Field.PADDING;
                case DOWN:
                    return getPos().getY() + direction.getRowDifference() < Field.height;
                default:
                    return false;
            }

        }
}
