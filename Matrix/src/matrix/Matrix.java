package matrix;

import java.util.Arrays;

class Matrix {

    // Find the shorted distance to a 0.
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][]result = new int[rows][cols];
        Arrays.stream(result).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        // First pass: top and left
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                int pixel = mat[row][col];
                if (pixel == 0) {
                    result[row][col] = pixel;
                }
                else {
                    if (row != 0) {
                        result[row][col] = Integer.min(result[row][col], result[row-1][col] == Integer.MAX_VALUE ? Integer.MAX_VALUE : result[row-1][col]+1);
                    }
                    if (col != 0) {
                        result[row][col] = Integer.min(result[row][col], result[row][col-1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : result[row][col-1]+1);
                    }
                }
            }
        }
        // Second pass: bottom and right
        for (int row = rows-1; row >=0; row--) {
            for (int col = cols-1; col >=0; col--) {
                if (row != rows-1) {
                    result[row][col] = Integer.min(result[row][col], result[row+1][col] == Integer.MAX_VALUE ? Integer.MAX_VALUE : result[row+1][col]+1);
                }
                if (col != cols-1) {
                    result[row][col] = Integer.min(result[row][col], result[row][col+1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : result[row][col+1]+1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][][] testCases = {
            {
                {0,0,0},
                {0,1,0},
                {0,0,0}
            },
            {
                {0,0,0},
                {0,1,0},
                {1,1,1}
            },
        };
        Matrix ma = new Matrix();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:\n", i);
            int[][] result = ma.updateMatrix(testCases[i]);
            for (int j=0; j < result.length; j++) {
                System.out.println(Arrays.toString(result[j]));
            }
        }
    }
}