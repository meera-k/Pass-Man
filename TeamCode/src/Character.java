public class Character extends Drawable {
    private int direction, velocity;
    private static int panelWidth; // All enemies will share this information
    private static int panelHeight;

    protected boolean isMoving;

    public Character(int x, int y, int v) {
        super(x, y, 39, 66);
        direction = 0;
        velocity = v;
        isMoving = false;
    }

    public static void setPanelWidth(int w) {
        panelWidth = w;
    }
    public static void setPanelHeight(int h) {
        panelHeight = h;
    }

    public Direction moveLeft() {
        if(getX() > 0) {
            setX(getX() - velocity);
            isMoving = true;
            return Direction.LEFT;
        } else {
            isMoving = false;
            return Direction.NONE;
        }
    }

    public Direction moveRight() {
        if(getX() + getWidth() < panelWidth) {
            setX(getX() + velocity);
            isMoving = true;
            return Direction.RIGHT;
        } else {
            isMoving = false;
            return Direction.NONE;
        }
    }

    public Direction moveUp() {
        if(getY() > 0) {
            setY(getY() - velocity);
            isMoving = true;
            return Direction.UP;
        } else {
            isMoving = false;
            return Direction.NONE;
        }
    }

    public Direction moveDown() {
        if(getY() + getHeight() < panelHeight) {
            setY(getY() + velocity);
            isMoving = true;
            return Direction.UP;
        } else {
            isMoving = false;
            return Direction.NONE;
        }
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
        } else if (xVal < 0) {

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
