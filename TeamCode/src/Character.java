import java.awt.*;

public abstract class Character {

    private int centerX, centerY, width, height;
    private int direction, velocity;
    private static int panelWidth; // All enemies will share this information

    public Character(int x, int y, int w, int h, int v) {
        centerX = x;
        centerY = y;
        width = w;
        height = h;
        direction = 0;
        velocity = v;
    }

    public static void setPanelWidth(int w) {
        panelWidth = w;
    }

    public abstract void draw();

    // //needed if a mouse event is used (x, y represents mouse coordinates)
    // public boolean containsPoint(int x, int y){
    // int xSquared = (x - centerX) * (x - centerX);
    // int ySquared = (y - centerY) * (y - centerY);
    // int radiusSquared = radius * radius;
    // return xSquared + ySquared - radiusSquared <= 0;
    // }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return centerX;
    }

    public int getY() {
        return centerY;
    }

    public void moveLeft() {
        centerX -= 2;
    }

    public void moveRight() {
        centerX += 2;
    }

    public void moveUp() {
        centerY -= 2;
    }

    public void moveDown() {
        centerY += 2;
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

        if (xVal + width > panelWidth) { // include getWidth() so we bounce off on the right edge

            direction = 0; // negative;
            xVal -= velocity;
        } else if (xVal - width < 0) {

            xVal += velocity;
            direction = 1; // positive
        } else {
            if (direction == 1)
                xVal += velocity;
            else
                xVal -= velocity;
        }
        centerX = xVal;
    }

    public void move(int x, int w) {// moves side to side
        centerX = x - w; // setX(x - w);

    }
    // public void moveMouse(int dx, int dy)
    // {
    // centerX += dx;
    // centerY += dy;
    // }
}
