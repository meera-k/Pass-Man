import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class HallMonitor extends Character {
    private String imagePath = "graphics/sharon.png";
    private ImageIcon img = new ImageIcon(imagePath);
    private Image scaled = scaleImage(img.getImage(),100,100);
    private ImageIcon scaledIcon = new ImageIcon(scaled);

    public HallMonitor(int x, int y, int w, int h, int v) {
        super(x,y,w,h,v);
    }

    public void draw(Graphics g) {
        g.drawImage(scaledIcon.getImage(),getX(),getY(),null);
    }
}