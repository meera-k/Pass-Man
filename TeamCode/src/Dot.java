/*
Dot that the player eats, just like in normal Pac-Man
Sydney Tran, Meera Kumar, Emily Chen
v1.0
*/

import javax.swing.*;
import java.awt.*;

public class Dot extends Food {
    // Image stuff
    private static String imagePath = "graphics/dot.png";
    private static int pointVal = 10;
    private ImageIcon img = new ImageIcon(imagePath);
    private Image scaled = scaleImage(img.getImage(), 100, 100);
    private ImageIcon scaledIcon = new ImageIcon(scaled);

    public Dot(int x, int y) {
        super(x, y, 15, 15, imagePath, pointVal);
    }

    public void draw(Graphics g) {
        g.drawImage(scaledIcon.getImage(), getX(), getY(), null);
    }
}
