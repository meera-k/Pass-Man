public class HallMonitor1 extends HallMonitor { // TODO: change name and add move algorithm
    public HallMonitor1(int x, int y, int v) {
        super(x,y,v);
    }

    public void move(int charX, int charY, Map map) {
        switch(direction) {
            case LEFT:
                if(map.isWall(getX() - 1, getY())) {
                    direction = Direction.values()[(int)(Math.random() * 4)];
                }
                break;
            case RIGHT:
                if(map.isWall(getX() + 1, getY())) {
                    direction = Direction.values()[(int)(Math.random() * 4)];
                }
                break;
            case UP:
                if(map.isWall(getX(), getY() - 1)) {
                    direction = Direction.values()[(int)(Math.random() * 4)];
                }
                break;
            case DOWN:
                if(map.isWall(getX(), getY() + 1)) {
                    direction = Direction.values()[(int)(Math.random() * 4)];
                }
                break;
            default:
                direction = Direction.values()[(int)(Math.random() * 4)];
        }

        switch(direction) {
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
        }
    }
}
