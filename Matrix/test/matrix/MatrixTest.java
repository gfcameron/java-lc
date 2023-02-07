package matrix;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class MatrixTest {

    private static Matrix ma;

    @BeforeClass
    public static void setUp() throws Exception {
        ma = new Matrix();
    }

    @Test
    public void case0() {
        int[][] matrix = new int[][]{
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        int[][] expectedCase = new int[][]{
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        int[][] result = ma.updateMatrix(matrix);
        Assert.assertArrayEquals(expectedCase, result);
    }


    @Test
    public void case1() {
        int[][] matrix = new int[][]{
            {0,0,0},
            {0,1,0},
            {1,1,1}
        };
        int[][] expectedCase = new int[][]{
            {0,0,0},
            {0,1,0},
            {1,2,1}
        };
        int[][] result = ma.updateMatrix(matrix);
        Assert.assertArrayEquals(expectedCase, result);
    }


    @Test
    public void case2() {
        int[][] matrix = new int[][]{
            {0}
        };
        int[][] expectedCase = new int[][]{
            {0}
        };
        int[][] result = ma.updateMatrix(matrix);
        Assert.assertArrayEquals(expectedCase, result);
    }

    @Test
    public void case3() {
        // Illegal but check anyway...
        int[][] matrix = new int[][]{
            {0,1,1},
            {1,1,1},
            {1,1,1},
        };
        int[][] expectedCase = new int[][]{
            {0,1,2},
            {1,2,3},
            {2,3,4}
        };
        int[][] result = ma.updateMatrix(matrix);
        Assert.assertArrayEquals(expectedCase, result);
    }

    @Test
    public void case4() {
        // Illegal but check anyway...
        int[][] matrix = new int[][]{
            {1,1,0},
            {1,1,1},
            {1,1,1},
        };
        int[][] expectedCase = new int[][]{
            {2,1,0},
            {3,2,1},
            {4,3,2}
        };
        int[][] result = ma.updateMatrix(matrix);
        Assert.assertArrayEquals(expectedCase, result);
    }

    @Test
    public void case5() {
        // Illegal but check anyway...
        int[][] matrix = new int[][]{
            {1,1,1},
            {1,1,1},
            {0,1,1},
        };
        int[][] expectedCase = new int[][]{
            {2,3,4},
            {1,2,3},
            {0,1,2}
        };
        int[][] result = ma.updateMatrix(matrix);
        Assert.assertArrayEquals(expectedCase, result);
    }

    @Test
    public void case6() {
        // Illegal but check anyway...
        int[][] matrix = new int[][]{
            {1,1,1},
            {1,1,1},
            {1,1,0},
        };
        int[][] expectedCase = new int[][]{
            {4,3,2},
            {3,2,1},
            {2,1,0}
        };
        int[][] result = ma.updateMatrix(matrix);
        Assert.assertArrayEquals(expectedCase, result);
    }

    @Test
    public void case7() {
        // Illegal input but check anyway...
        int[][] matrix = new int[][]{
            {1,1,1},
            {1,1,1},
            {1,1,1},
        };
        int[][] expectedCase = new int[][]{
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}
        };
        int[][] result = ma.updateMatrix(matrix);
        Assert.assertArrayEquals(expectedCase, result);
    }

}