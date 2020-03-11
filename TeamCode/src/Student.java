import javax.swing.*;
import java.awt.*;

public class Student extends Character {
    private final String stillPath = "graphics/student1.png";
    private final ImageIcon still = new ImageIcon(stillPath);
    private final Image scaledStill = scaleImage(still.getImage(),39,66);
    private final ImageIcon scaledStillIcon = new ImageIcon(scaledStill);

    private final String f1Path = "graphics/student1_walking_right_frame1.png";
    private final ImageIcon f1 = new ImageIcon(f1Path);
    private final Image scaledf1 = scaleImage(f1.getImage(), 45, 66);
    private final ImageIcon right1 = new ImageIcon(scaledf1);

    private final String f2Path = "graphics/student1_walking_right_frame2.png";
    private final ImageIcon f2 = new ImageIcon(f2Path);
    private final Image scaledf2 = scaleImage(f2.getImage(), 39, 66);
    private ImageIcon right2 = new ImageIcon(scaledf2);

    private static int cntr = 0;

    public Student(int x, int y, int v) {
        super(x,y,v);
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