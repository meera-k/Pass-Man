import java.awt.*;

public class Location {

    private boolean wall = false;
    private boolean drawn = false;

    public void draw(Graphics g, int x, int y, int width, int height)
    {
        if (wall && !drawn) {
            Color oldColor = g.getColor();
            g.setColor(Color.CYAN);
            g.fillRect(x, y, width, height);
            setDrawnTrue();
            g.setColor(oldColor);
        }
    }

    public void setDrawnTrue() {
        drawn = true;
    }

    public boolean getDrawn() {
        return drawn;
    }

    public void setWall() {
        wall = true;
    }

    public boolean getWall() {
        return wall;
    }
}