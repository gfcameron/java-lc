package maxarea;

class MaxAreaOfIsland {

    // Keep track of checked for all island squares
    // Set pixels -ve if checked
    // Step pixel by pixel, skippign checked ones.

    int checkIsland(int[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }
        // Checked or ocean
        if (grid[row][col] <= 0) {
            return 0;
        }
        // Mark as checked
        grid[row][col] = -1;
        int result = 1;
        result += checkIsland(grid, row-1, col);
        result += checkIsland(grid, row+1, col);
        result += checkIsland(grid, row, col-1);
        result += checkIsland(grid, row, col+1);
        return result;
    }


    public int maxAreaOfIsland(int[][] grid) {

        int biggestArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int pixel = grid[row][col];
                switch (pixel) {
                    case -1: // Checked island
                    case 0: // Water
                    break;
                    case 1: // Unchecked island
                    int area = checkIsland(grid, row, col);
                    if (area > biggestArea) {
                        biggestArea = area;
                    }
                    break;
                }
            }
        }
        return biggestArea;
    }


    public static void main(String[] args) {

        int[][][] testCases = {
            {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
            },
            {
                {0,0,0,0,0,0,0,0}
            }
        };
        MaxAreaOfIsland ma = new MaxAreaOfIsland();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: %d\n", i, ma.maxAreaOfIsland(testCases[i]));
        }
    }
}