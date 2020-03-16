import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class HallMonitor extends Character {
    // Image stuff
    private String imagePath = "graphics/sharon.png";
    private ImageIcon img = new ImageIcon(imagePath);
    private Image scaledStill = scaleImage(img.getImage(), 26, 44);

    private String rightf1Path = "graphics/sharon_walking_right_frame1.png";
    private ImageIcon rightf1 = new ImageIcon(rightf1Path);
    private Image rightscaledf1 = scaleImage(rightf1.getImage(), 30, 44);

    private String rightf2Path = "graphics/sharon_walking_right_frame2.png";
    private ImageIcon rightf2 = new ImageIcon(rightf2Path);
    private Image rightscaledf2 = scaleImage(rightf2.getImage(), 26, 44);

    private String leftf1Path = "graphics/sharon_walking_left_frame1.png";
    private ImageIcon leftf1 = new ImageIcon(leftf1Path);
    private Image leftscaledf1 = scaleImage(leftf1.getImage(), 30, 44);

    private String leftf2Path = "graphics/sharon_walking_left_frame2.png";
    private ImageIcon leftf2 = new ImageIcon(leftf2Path);
    private Image leftscaledf2 = scaleImage(leftf2.getImage(), 26, 44);

    private int cntr = 0;

    public HallMonitor(int x, int y, int v) {
        super(x, y, v);
    }

    /**
     * if (!checkWall(student.getX() - 1, student.getY()) && !checkWall(student.getX() - 1, student.getY() + 44 + 1))
                    student.moveLeft();
                break;
            case RIGHT:
                if (!checkWall(student.getX() + 1 + 26, student.getY()) && !checkWall(student.getX() + 1 + 26, student.getY() + 44 + 1))
                    student.moveRight();
                break;
            case UP:
                if (!checkWall(student.getX(), student.getY() - 1) && !checkWall(student.getX() + 26 + 1, student.getY() - 1))
                    student.moveUp();
                break;
            case DOWN:
                if (!checkWall(student.getX(), student.getY() + 1 + 44) && !checkWall(student.getX() + 26 + 1, student.getY() + 1 + 44))
                    student.moveDown();
                break;
     */

    public void move(int charX, int charY, Map map) {
        int diffX = getX() - charX;
        int diffY = getY() - charY;

        if(Math.abs(diffX) > Math.abs(diffY)) { // If HallMonitor is further away in the x-direction than the y-direction
            if(diffX > 0 && (!map.isWall(getX() - 1, getY()) && !map.isWall(getX() - 1, getY() + 44 + 1))) { // HallMonitor is further right than student
                moveLeft();
            } else if (diffX < 0 && (!map.isWall(getX() + 1 + 26, getY()) && !map.isWall(getX() + 1 + 26, getY() + 44 + 1))){
                moveRight();
            } else {
                if(diffX > 0 && (!map.isWall(getX() - 1, getY()) && !map.isWall(getX() - 1, getY() + 44 + 1))) { // HallMonitor is further right than student
                    moveLeft();
                } else if (diffX < 0 && (!map.isWall(getX() + 1 + 26, getY()) && !map.isWall(getX() + 1 + 26, getY() + 44 + 1))){
                    moveRight();
                } else if(diffY > 0 && (!map.isWall(getX(), getY() - 1) && !map.isWall(getX() + 26 + 1, getY() - 1))) { // HallMonitor is further down than student
                    moveUp();
                } else if (diffY < 0 && (!map.isWall(getX() + 1 + 44, getY()) && !map.isWall(getX() + 26 + 1, getY() + 1 + 44))){
                    moveDown();
                } else {
                    System.out.println("nice");
                    direction = Direction.NONE;
                }
            }
        } else {
            if(diffY > 0 && (!map.isWall(getX(), getY() - 1) && !map.isWall(getX() + 26 + 1, getY() - 1))) { // HallMonitor is further down than student
                moveUp();
            } else if (diffY < 0 && (!map.isWall(getX() + 1 + 44, getY()) && !map.isWall(getX() + 26 + 1, getY() + 1 + 44))){
                moveDown();
            } else {
                if(diffX > 0 && (!map.isWall(getX() - 1, getY()) && !map.isWall(getX() - 1, getY() + 44 + 1))) { // HallMonitor is further right than student
                    moveLeft();
                } else if (diffX < 0 && (!map.isWall(getX() + 1 + 26, getY()) && !map.isWall(getX() + 1 + 26, getY() + 44 + 1))){
                    moveRight();
                } else if(diffY > 0 && (!map.isWall(getX(), getY() - 1) && !map.isWall(getX() + 26 + 1, getY() - 1))) { // HallMonitor is further down than student
                    moveUp();
                } else if (diffY < 0 && (!map.isWall(getX() + 1 + 44, getY()) && !map.isWall(getX() + 26 + 1, getY() + 1 + 44))){
                    moveDown();
                } else {
                    System.out.println("nice");
                    direction = Direction.NONE;
                }
            }
        }
    }

    @Override
    public void drawStill(Graphics g) {
        g.drawImage(scaledStill, getX(), getY(), null);
    }

    @Override
    public void drawMovingLeft(Graphics g) {
        switch((cntr / 8) % 2) {
            case 0:
                g.drawImage(leftscaledf1, getX(), getY(), null);
                cntr++;
                break;
            case 1:
                g.drawImage(leftscaledf2, getX(), getY(), null);
                cntr++;
                break;
        }
    }

    @Override
    public void drawMovingRight(Graphics g) {
        switch((cntr / 8) % 2) {
            case 0:
                g.drawImage(rightscaledf1, getX(), getY(), null);
                cntr++;
                break;
            case 1:
                g.drawImage(rightscaledf2, getX(), getY(), null);
                cntr++;
                break;
        }
    }

    @Override
    public void drawMovingUp(Graphics g) {
        switch((cntr / 8) % 2) {
            case 0:
                g.drawImage(rightscaledf1, getX(), getY(), null);
                cntr++;
                break;
            case 1:
                g.drawImage(rightscaledf2, getX(), getY(), null);
                cntr++;
                break;
        }
    }

    @Override
    public void drawMovingDown(Graphics g) {
        switch((cntr / 8) % 2) {
            case 0:
                g.drawImage(rightscaledf1, getX(), getY(), null);
                cntr++;
                break;
            case 1:
                g.drawImage(rightscaledf2, getX(), getY(), null);
                cntr++;
                break;
        }
    }
}