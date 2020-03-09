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

    }

    public int getNumCols() {
        return numCols;
    }

    public int getNumRows() {
        return numRows;
    }


}