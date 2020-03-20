import java.awt.*;

public abstract class Character extends Drawable {
    private int velocity;
    private static int panelWidth; // All enemies will share this information
    private static int panelHeight;

    protected Direction direction;

    public Character(int x, int y, int v) {
        super(x, y, 26, 44);
        direction = Direction.NONE;
        velocity = v;
    }

    public static void setPanelWidth(int w) {
        panelWidth = w;
    }
    public static void setPanelHeight(int h) {
        panelHeight = h;
    }

    public Direction moveLeft() {
        if(getX() - velocity > 0) {
            setX(getX() - velocity);
            direction = Direction.LEFT;
            return Direction.LEFT;
        } else {
            direction = Direction.NONE;
            return Direction.NONE;
        }
    }

    public Direction moveRight() {
        if(getX() + getWidth() + velocity < panelWidth) {
            setX(getX() + velocity);
            direction = Direction.RIGHT;
            return Direction.RIGHT;
        } else {
            direction = Direction.NONE;
            return Direction.NONE;
        }
    }

    public Direction moveUp() {
        if(getY() - velocity > 0) {
            setY(getY() - velocity);
            direction = Direction.UP;
            return Direction.UP;
        } else {
            direction = Direction.NONE;
            return Direction.NONE;
        }
    }

    public Direction moveDown() {
        if(getY() + getHeight() + velocity < panelHeight) {
            setY(getY() + velocity);
            direction = Direction.DOWN;
            return Direction.DOWN;
        } else {
            direction = Direction.NONE;
            return Direction.NONE;
        }
    }

    public void setVelocity(int v) {
        velocity = v;
    }

    public int getVelocity() {
        return velocity;
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
        switch(direction) {
            case LEFT:
                drawMovingLeft(g);
                break;
            case RIGHT:
                drawMovingRight(g);
                break;
            case UP:
                drawMovingUp(g);
                break;
            case DOWN:
                drawMovingDown(g);
                break;
            case NONE:
                drawStill(g);
                break;
        }
    }

    public abstract void drawStill(Graphics g);
    public abstract void drawMovingLeft(Graphics g);
    public abstract void drawMovingRight(Graphics g);
    public abstract void drawMovingUp(Graphics g);
    public abstract void drawMovingDown(Graphics g);

}
