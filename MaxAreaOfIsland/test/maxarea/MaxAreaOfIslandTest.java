package maxarea;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class MaxAreaOfIslandTest {

    private static MaxAreaOfIsland ma;

    @BeforeClass
    public static void setUp() throws Exception {
        ma = new MaxAreaOfIsland();
    }

    @Test
    public void case0() {
        int[][] testCase = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int expectedCase = 6;
        Assert.assertEquals(expectedCase, ma.maxAreaOfIsland(testCase));
    }

}