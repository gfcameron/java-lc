package floodfill;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FloodFillTest {


    private static FloodFill ff;

    @BeforeClass
    public static void setUp() throws Exception {
        ff = new FloodFill();
    }

    @Test
    public void case0() {
        int[][] matrix = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int[][] expectedCase = new int[][]{{2,2,2},{2,2,0},{2,0,1}};
        Assert.assertArrayEquals(expectedCase, ff.floodFill(matrix, 1, 1, 2));
    }

    @Test
    public void case1() {
        int[][] matrix = new int[][]{{0,0,0},{0,0,0}};
        int[][] expectedCase = new int[][]{{0,0,0},{0,0,0}};
        Assert.assertArrayEquals(expectedCase, ff.floodFill(matrix, 0, 0, 0));
    }
}