/*
Dot that the player eats, just like in normal Pac-Man
Sydney Tran, Meera Kumar, Emily Chen
v1.0
*/

import javax.swing.*;
import java.awt.*;

public class Dot extends Food {
    private final static int WIDTH = 10, HEIGHT = 10;

    // Image stuff
    private static String imagePath = "graphics/dot.png";
    private static int pointVal = 10;
    private ImageIcon img = new ImageIcon(imagePath);
    private Image scaled = scaleImage(img.getImage(), WIDTH, HEIGHT);

    public Dot(int x, int y) {
        super(x, y, WIDTH, HEIGHT, imagePath, pointVal);
    }

    public void draw(Graphics g) {
        g.drawImage(scaled, getX() - getWidth() / 2, getY() - getHeight() / 2, null);
    }
}
