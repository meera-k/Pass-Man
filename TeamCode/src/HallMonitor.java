import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

import static com.sun.javafx.iio.common.ImageTools.scaleImage;

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