import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class HallMonitor extends Character {
    // Image stuff
    private String imagePath = "graphics/sharon.png";
    private ImageIcon img = new ImageIcon(imagePath);
    private Image scaledStill = scaleImage(img.getImage(), 39, 66);
    private ImageIcon scaledStillIcon = new ImageIcon(scaledStill);

    private String f1Path = "graphics/sharon_walking_right_frame1.png";
    private ImageIcon f1 = new ImageIcon(f1Path);
    private Image scaledf1 = scaleImage(f1.getImage(), 45, 66);
    private ImageIcon right1 = new ImageIcon(scaledf1);

    private String f2Path = "graphics/sharon_walking_right_frame2.png";
    private ImageIcon f2 = new ImageIcon(f2Path);
    private Image scaledf2 = scaleImage(f2.getImage(), 39, 66);
    private ImageIcon right2 = new ImageIcon(scaledf2);

    private int cntr = 0;

    public HallMonitor(int x, int y, int v) {
        super(x, y, v);
    }

    public void move(int charX, int charY) {
        int diffX = getX() - charX;
        int diffY = getY() - charY;

        if(Math.abs(diffX) > Math.abs(diffY)) { // If HallMonitor is further away in the x-direction than the y-direction
            if(diffX > 0) { // HallMonitor is further right than student
                moveLeft();
            } else {
                moveRight();
            }
        } else {
            if(diffY > 0) { // HallMonitor is further down than student
                moveUp();
            } else {
                moveDown();
            }
        }
    }

    @Override
    public void drawStill(Graphics g) {
        g.drawImage(scaledStill, getX(), getY(), null);
    }

    @Override
    public void drawMovingLeft(Graphics g) {

    }

    @Override
    public void drawMovingRight(Graphics g) {
        switch((cntr / 8) % 2) {
            case 0:
                g.drawImage(scaledf1, getX(), getY(), null);
                cntr++;
                break;
            case 1:
                g.drawImage(scaledf2, getX(), getY(), null);
                cntr++;
                break;
        }
    }

    @Override
    public void drawMovingUp(Graphics g) {

    }

    @Override
    public void drawMovingDown(Graphics g) {

    }
}