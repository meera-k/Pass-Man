import java.awt.*;

public class Map {
    private Location[][] grid;
    private int numRows, numCols;

    public Map(int r, int c) {
        grid = new Location[r][c];
        numRows = r;
        numCols = c;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                grid[row][col] = new Location();
            }
        }

        // set walls

    }

    public void draw(Graphics g) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                grid[row][col].draw(g);
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