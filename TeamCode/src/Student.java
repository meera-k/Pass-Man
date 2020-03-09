import java.awt.*;

public class Student extends Character {
    private String imagePath = "graphics/pass.png";
    public Student(int x, int y, int w, int h, int v) {
        super(x,y,w,h,v);
    }

    public void draw(Graphics g) {
        super.draw(g, imagePath);
    }
}