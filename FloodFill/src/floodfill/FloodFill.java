package floodfill;

import java.util.Arrays;

class FloodFill {

    private void floodFillHelper(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        // Only fill if the color matches the replace value, if already new color then nothing to do.
        int color = image[sr][sc];
        if ((color != oldColor) || (color == newColor)) {
            return;
        }
        image[sr][sc] = newColor;
        floodFillHelper(image, sr-1, sc, newColor, oldColor);
        floodFillHelper(image, sr+1, sc, newColor, oldColor);
        floodFillHelper(image, sr, sc-1, newColor, oldColor);
        floodFillHelper(image, sr, sc+1, newColor, oldColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        floodFillHelper(image, sr, sc, color, oldColor);
        return image;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        class TestCase {
            int[][] image;
            int sr;
            int sc;
            int color;

            TestCase(int[][]image, int sr, int sc, int color) {
                this.image = image;
                this.sr = sr;
                this.sc = sc;
                this.color = color;
            } 
        };

        TestCase[] testCases = {
            new TestCase(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1, 1, 2),
            new TestCase(new int[][]{{0,0,0},{0,0,0}},0, 0, 0)
        };

        FloodFill ff = new FloodFill();
        for ( int i=0; i < testCases.length; i++ ) {
            TestCase tc = testCases[i];
            System.out.printf("Case %d:\n", i);
            int[][] result = ff.floodFill(tc.image, tc.sr, tc.sc, tc.color);
            for (int j=0; j < result.length; j++) {
                System.out.println(Arrays.toString(result[j]));
            }           
        }
    }
}