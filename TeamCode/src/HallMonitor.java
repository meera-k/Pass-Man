import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HallMonitor extends Character {
    private String imagePath = "graphics/sharon.png";
    /*try {
        BufferedImage image = ImageIO.read(new File(imagePath));
    } catch(IOException e) {

    }*/
    public HallMonitor(int x, int y, int w, int h, int v) {
        super(x,y,w,h,v);
    }

    public void draw(Graphics g) {
        g.drawImage(new ImageIcon(imagePath).getImage(),getX(),getY(),null);
    }
}