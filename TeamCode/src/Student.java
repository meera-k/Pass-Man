import javax.swing.*;
import java.awt.*;

public class Student extends Character {
    private String imagePath = "graphics/student1.png";
    private ImageIcon img = new ImageIcon(imagePath);
    private Image scaled = scaleImage(img.getImage(),39,66);
    private ImageIcon scaledIcon = new ImageIcon(scaled);

    public Student(int x, int y, int v) {
        super(x,y,v);
    }

    public void draw(Graphics g) {
        g.drawImage(scaledIcon.getImage(), getX(), getY(), null);
    }
}