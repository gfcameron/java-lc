package movezeroes;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoverZeroesTest {


    private static MoveZeroes mz = new MoveZeroes();

    @BeforeClass
    public static void setUp() throws Exception {
        mz = new MoveZeroes();
    }

    @Test
    public void case0() {
        int[] testCase = {0,1,0,3,12};
        int[] expectedCase = {1,3,12,0,0};
        mz.moveZeroes(testCase);
        Assert.assertArrayEquals(expectedCase, testCase);
    }
    
    @Test
    public void case1() {
        int[] testCase = {0};
        int[] expectedCase = {0};
        mz.moveZeroes(testCase);
        Assert.assertArrayEquals(expectedCase, testCase);
    }

    @Test
    public void case2() {
        int[] testCase = {1};
        int[] expectedCase = {1};
        mz.moveZeroes(testCase);
        Assert.assertArrayEquals(expectedCase, testCase);
    }

    @Test
    public void case3() {
        int[] testCase = {1,2};
        int[] expectedCase = {1,2};
        mz.moveZeroes(testCase);
        Assert.assertArrayEquals(expectedCase, testCase);
    }

}