import java.awt.*;

public class Location {

    private boolean wall = false;

    public void draw(Graphics g, int x, int y, int width, int height)
    {
        if (wall) {
            Color oldColor = g.getColor();
            g.setColor(Color.CYAN);
            g.fillRect(x, y, width, height);
            g.setColor(oldColor);
        }
    }

    public void setWall() {
        wall = true;
    }

    public boolean getWall() {
        return wall;
    }
}