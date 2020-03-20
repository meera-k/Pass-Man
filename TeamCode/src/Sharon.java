public class Sharon extends HallMonitor {
    public Sharon(int x, int y, int v) {
        super(x,y,v);
    }

    public void move(int charX, int charY, Map map) {
        int diffX = getX() - charX;
        int diffY = getY() - charY;

        if(Math.abs(diffX) > Math.abs(diffY)) { // If HallMonitor is further away in the x-direction than the y-direction
            if(diffX > 0 && (!map.isWall(getX() - 1, getY()) && !map.isWall(getX() - 1, getY() + getHeight() + 1))) { // HallMonitor is further right than student
                moveLeft();
            } else if (diffX < 0 && (!map.isWall(getX() + 1 + getWidth(), getY()) && !map.isWall(getX() + 1 + getWidth(), getY() + getHeight() + 1))){
                moveRight();
            } else {
                if(diffX > 0 && (!map.isWall(getX() - 1, getY()) && !map.isWall(getX() - 1, getY() + getHeight() + 1))) { // HallMonitor is further right than student
                    moveLeft();
                } else if (diffX < 0 && (!map.isWall(getX() + 1 + getWidth(), getY()) && !map.isWall(getX() + 1 + getWidth(), getY() + getHeight() + 1))){
                    moveRight();
                } else if(diffY > 0 && (!map.isWall(getX(), getY() - 1) && !map.isWall(getX() + getWidth() + 1, getY() - 1))) { // HallMonitor is further down than student
                    moveUp();
                } else if (diffY < 0 && (!map.isWall(getX() + 1 + getHeight(), getY()) && !map.isWall(getX() + getWidth() + 1, getY() + 1 + getHeight()))){
                    moveDown();
                } else {
                    direction = Direction.NONE;
                }
            }
        } else {
            if(diffY > 0 && (!map.isWall(getX(), getY() - 1) && !map.isWall(getX() + 26 + 1, getY() - 1))) { // HallMonitor is further down than student
                moveUp();
            } else if (diffY < 0 && (!map.isWall(getX() + 1 + 44, getY()) && !map.isWall(getX() + 26 + 1, getY() + 1 + 44))){
                moveDown();
            } else {
                if(diffX > 0 && (!map.isWall(getX() - 1, getY()) && !map.isWall(getX() - 1, getY() + 44 + 1))) { // HallMonitor is further right than student
                    moveLeft();
                } else if (diffX < 0 && (!map.isWall(getX() + 1 + 26, getY()) && !map.isWall(getX() + 1 + 26, getY() + 44 + 1))){
                    moveRight();
                } else if(diffY > 0 && (!map.isWall(getX(), getY() - 1) && !map.isWall(getX() + 26 + 1, getY() - 1))) { // HallMonitor is further down than student
                    moveUp();
                } else if (diffY < 0 && (!map.isWall(getX() + 1 + 44, getY()) && !map.isWall(getX() + 26 + 1, getY() + 1 + 44))){
                    moveDown();
                } else {
                    direction = Direction.NONE;
                }
            }
        }
    }
}
