package sorted;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class SortedSquaresTest {

    private static SortedSquares ss;

    @BeforeClass
    public static void setUp() throws Exception {
        ss = new SortedSquares();
    }

    @Test
    public void case0() {
        int[] testCase = {-4,-1,0,3,10};
        int[] expectedCase = {0,1,9,16,100};
        Assert.assertArrayEquals(expectedCase, ss.sortedSquares(testCase));
    }
    

    @Test
    public void case1() {
        int[] testCase = {-7,-3,2,3,11};
        int[] expectedCase = {4,9,9,49,121};
        Assert.assertArrayEquals(expectedCase, ss.sortedSquares(testCase));
    }

}