public class Character extends Drawable {
    private int direction, velocity;
    private static int panelWidth; // All enemies will share this information

    public Character(int x, int y, int w, int h, int v) {
        super(x, y, w, h);
        direction = 0;
        velocity = v;
    }

    public static void setPanelWidth(int w) {
        panelWidth = w;
    }

    public void moveLeft() {
        changeX(-2);
    }

    public void moveRight() {
        changeX(2);
    }

    public void moveUp() {
        changeY(-2);
    }

    public void moveDown() {
        changeY(2);
    }

    public int getDirection() {
        return direction;
    }

    public void setVelocity(int v) {
        velocity = v;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setDirection(int d) {
        direction = d % 360;
    }

    public void turn(int degrees) {
        direction = (direction + degrees) % 360;
    }

    // Moves the circle in the current direction using its
    // current velocity
    public void move() {
        int xVal = getX();

        if (xVal + getWidth() > panelWidth) { // include getWidth() so we bounce off on the right edge

            direction = 0; // negative;
            xVal -= velocity;
        } else if (xVal - getWidth() < 0) {

            xVal += velocity;
            direction = 1; // positive
        } else {
            if (direction == 1)
                xVal += velocity;
            else
                xVal -= velocity;
        }
        setX(xVal);
    }

    public void move(int x, int w) {// moves side to side
        setX(x - w);
    }
    // public void moveMouse(int dx, int dy)
    // {
    // centerX += dx;
    // centerY += dy;
    // }
}
