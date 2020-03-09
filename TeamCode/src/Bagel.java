import javax.swing.*;
import java.awt.*;

public class Bagel extends Snack {
    private static final int POINT_VAL = 100;

    // Image stuff
    private static final String PATH = "Pass-Man Drawings/bagel.png";
    private ImageIcon img = new ImageIcon(PATH);
    private Image scaled = scaleImage(img.getImage(), 100, 100);
    private ImageIcon scaledIcon = new ImageIcon(scaled);

    public Bagel(int x, int y) {
        super(x, y, 55, 45, PATH, POINT_VAL);
    }

    public void draw(Graphics g) {
        g.drawImage(scaledIcon.getImage(), getX(), getY(), null);
    }
}