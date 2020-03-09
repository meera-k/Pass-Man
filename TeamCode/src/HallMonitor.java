import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class HallMonitor extends Character {
    // Image stuff
    private String imagePath = "graphics/sharon.png";
    private ImageIcon img = new ImageIcon(imagePath);
    private Image scaled = scaleImage(img.getImage(), 39, 66);
    private ImageIcon scaledIcon = new ImageIcon(scaled);

    public HallMonitor(int x, int y, int v) {
        super(x, y, v);
    }

    public void draw(Graphics g) {
        g.drawImage(scaledIcon.getImage(), getX(), getY(), null);
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
}