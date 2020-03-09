import java.awt.*;
import javax.swing.*;

public abstract class Drawable {
    private int centerX, centerY, width, height;

    public Drawable(int x, int y, int w, int h) {
        centerX = x;
        centerY = y;
        width = w;
        height = h;
    }

    protected Image scaleImage(Image image, int w, int h) {

        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);

        return scaled;
    }

    public void draw(Graphics g, String imagePath) {
        g.drawImage(new ImageIcon(imagePath).getImage(), getX(), getY(), null);
    }

    //needed if a mouse event is used (x, y represents mouse coordinates)
    //TODO: use this maybe?(?)
    // public boolean containsPoint(int x, int y){
    //     int xSquared = (x - centerX) * (x - centerX);
    //     int ySquared = (y - centerY) * (y - centerY);
    //     int radiusSquared = radius * radius;
    //     return xSquared + ySquared - radiusSquared <= 0;
    // }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return centerX;
    }

    public void changeX(int i) {
        centerX += i;
    }

    public void setX(int i) {
        centerX = i;
    }

    public int getY() {
        return centerY;
    }

    public void changeY(int i) {
        centerY += i;
    }

    public void setY(int i) {
        centerY = i;
    }
}