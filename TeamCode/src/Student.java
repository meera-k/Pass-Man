import javax.swing.*;
import java.awt.*;

public class Student extends Character {
    private final String stillPath = "graphics/student1.png";
    private final ImageIcon still = new ImageIcon(stillPath);
    private final Image scaledStill = scaleImage(still.getImage(),26,44);

    private String rightf1Path = "graphics/student1_walking_right_frame1.png";
    private ImageIcon rightf1 = new ImageIcon(rightf1Path);
    private Image rightscaledf1 = scaleImage(rightf1.getImage(), 30, 44);

    private String rightf2Path = "graphics/student1_walking_right_frame2.png";
    private ImageIcon rightf2 = new ImageIcon(rightf2Path);
    private Image rightscaledf2 = scaleImage(rightf2.getImage(), 26, 44);

    private String leftf1Path = "graphics/student1_walking_left_frame1.png";
    private ImageIcon leftf1 = new ImageIcon(leftf1Path);
    private Image leftscaledf1 = scaleImage(leftf1.getImage(), 30, 44);

    private String leftf2Path = "graphics/student1_walking_left_frame2.png";
    private ImageIcon leftf2 = new ImageIcon(leftf2Path);
    private Image leftscaledf2 = scaleImage(leftf2.getImage(), 26, 44);

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

    public void setDirection(Direction d) {
        direction = d;
    }
}