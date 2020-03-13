import java.awt.*;

public class Map {
    private Location[][] grid;
    private int numRows, numCols;
    private int width, height;

    public Map(int w, int h) {
        grid = new Location[13][19];
        numRows = 13;
        numCols = 19;
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
            grid[12][col].setWall();
        }
        for (int row = 0; row < numRows; row++) {
                grid[row][0].setWall();
                grid[row][18].setWall();
        }
        // set other walls
        for (int col = 2; col <= 16; col++) {
            if (col != 5 && col != 9 && col != 13) {
                grid[2][col].setWall();
                grid[10][col].setWall();
            }
        }
        for (int row = 2; row <= 10; row++) {
            if (row != 4 && row != 8) {
                grid[row][2].setWall();
                grid[row][16].setWall();
            }
        }

        // set AHS
        for (int col = 4; col <= 14; col++) {
            if (col != 7 && col != 9 && col != 11) {
                grid[4][col].setWall();
            }
        }
        for (int col = 4; col <= 12; col++) {
            if (col != 5 && col != 7 && col != 9 && col != 11) {
                grid[5][col].setWall();
            }
        }
        for (int col = 4; col <= 14; col++) {
            if (col != 7 && col != 11) {
                grid[6][col].setWall();
            }
        }
        for (int col = 4; col <= 14; col++) {
            if (col != 5 && col != 7 && col != 9 && col != 11 && col != 12 && col != 13) {
                grid[7][col].setWall();
            }
        }
        for (int col = 4; col <= 14; col++) {
            if (col != 5 && col != 7 && col != 9 && col != 11) {
                grid[8][col].setWall();
            }
        }

    }

    public void draw(Graphics g) {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                grid[row][col].draw(g, col * width, row * height, width, height);
            }
        }
    }

    public int getNumCols() {
        return numCols;
    }

    public int getNumRows() {
        return numRows;
    }

    public boolean isWall(int x, int y) {
        for (int row = 0; row < numRows - 1; row++) {
            for (int col = 0; col < numCols - 1; col++) {
                if (col * width <= x && (col + 1) * width >= x && row * height <= y && (row + 1) * height >= y) {
                    return grid[row][col].getWall();
                }
            }
        }
        return false;
    }
}