public class Location {

    private boolean wall = false;
    private boolean drawn = false;

    public void draw()
    {
        if (wall && !drawn) {
            // draw
            setDrawnTrue();
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