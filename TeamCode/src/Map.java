import java.awt.*;

public class Map {
    private Location[][] grid;
    private int numRows, numCols;
    private int width, height;

    public Map(int w, int h) {
        grid = new Location[19][13];
        numRows = 19;
        numCols = 13;
        width = w / 19;
        height = h / 13;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                grid[row][col] = new Location();
            }
        }

        // set border
        for (int col = 0; col < numCols; col++) {
            grid[0][col].setWall();
            grid[18][col].setWall();
        }
        for (int row = 0; row < numRows; row++) {
                grid[row][0].setWall();
                grid[row][12].setWall();
        }

    }

    public void draw(Graphics g) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                grid[row][col].draw(g, row * width, col * height, width, height);
            }
        }
    }

    public int getNumCols() {
        return numCols;
    }

    public int getNumRows() {
        return numRows;
    }


}