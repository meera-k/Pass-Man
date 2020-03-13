import java.awt.*;

public abstract class Character extends Drawable {
    private int direction, velocity;
    private static int panelWidth; // All enemies will share this information
    private static int panelHeight;

    protected boolean isMovingLeft, isMovingRight, isMovingUp, isMovingDown;

    public Character(int x, int y, int v) {
        super(x, y, 26, 44);
        direction = 0;
        velocity = v;
        isMovingLeft = false;
        isMovingRight = false;
        isMovingUp = false;
        isMovingDown = false;
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
            isMovingLeft = true;
            isMovingRight = false;
            isMovingUp = false;
            isMovingDown = false;
            return Direction.LEFT;
        } else {
            isMovingLeft = false;
            return Direction.NONE;
        }
    }

    public Direction moveRight() {
        if(getX() + getWidth() < panelWidth) {
            setX(getX() + velocity);
            isMovingLeft = false;
            isMovingRight = true;
            isMovingUp = false;
            isMovingDown = false;
            return Direction.RIGHT;
        } else {
            isMovingRight = false;
            return Direction.NONE;
        }
    }

    public Direction moveUp() {
        if(getY() > 0) {
            setY(getY() - velocity);
            isMovingLeft = false;
            isMovingRight = false;
            isMovingUp = true;
            isMovingDown = false;
            return Direction.UP;
        } else {
            isMovingUp = false;
            return Direction.NONE;
        }
    }

    public Direction moveDown() {
        if(getY() + getHeight() < panelHeight) {
            setY(getY() + velocity);
            isMovingLeft = false;
            isMovingRight = false;
            isMovingUp = false;
            isMovingDown = true;
            return Direction.DOWN;
        } else {
            isMovingUp = false;
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

    public void draw(Graphics g) {
        if(isMovingLeft) {
            drawMovingLeft(g);
        } else if(isMovingRight) {
            drawMovingRight(g);
        } else if(isMovingUp) {
            drawMovingRight(g);
        } else if(isMovingDown) {
            drawMovingRight(g);
        } else {
            drawStill(g);
        }
    }

    public abstract void drawStill(Graphics g);
    public abstract void drawMovingLeft(Graphics g);
    public abstract void drawMovingRight(Graphics g);
    public abstract void drawMovingUp(Graphics g);
    public abstract void drawMovingDown(Graphics g);

}
