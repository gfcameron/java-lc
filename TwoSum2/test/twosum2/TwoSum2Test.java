package twosum2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TwoSum2Test {


    private static TwoSum2 ts = new TwoSum2();

    @BeforeClass
    public static void setUp() throws Exception {
        ts = new TwoSum2();
    }

    @Test
    public void case0() {
        int[] testCase = {2,7,11,15};
        int[] expectedCase = {1,2};
        Assert.assertArrayEquals(expectedCase,ts.twoSum(testCase, 9));
    }
    

    @Test
    public void case1() {
        int[] testCase = {2,3,4};
        int[] expectedCase = {1,3};
        Assert.assertArrayEquals(expectedCase,ts.twoSum(testCase, 6));
    }


    @Test
    public void case2() {
        int[] testCase = {-1,0};
        int[] expectedCase = {1,2};
        Assert.assertArrayEquals(expectedCase,ts.twoSum(testCase, -1));
    }

    @Test
    public void case3() {
        int[] testCase = {1,2,3,4};
        int[] expectedCase = {-1,-1};
        Assert.assertArrayEquals(expectedCase,ts.twoSum(testCase, 0));
    }

    @Test
    public void case4() {
        int[] testCase = {1,2,3,4};
        int[] expectedCase = {-1,-1};
        Assert.assertArrayEquals(expectedCase,ts.twoSum(testCase, 9));
    }

    @Test
    public void case5() {
        int[] testCase = {1};
        int[] expectedCase = {-1,-1};
        Assert.assertArrayEquals(expectedCase,ts.twoSum(testCase, 2));
    }

    @Test
    public void case6() {
        int[] testCase = {0,1};
        int[] expectedCase = {-1,-1};
        Assert.assertArrayEquals(expectedCase,ts.twoSum(testCase, 2));
    }

    @Test
    public void case7() {
        int[] testCase = {0,0,3,4};
        int[] expectedCase = {1,2};
        Assert.assertArrayEquals(expectedCase,ts.twoSum(testCase, 0));
    }

}