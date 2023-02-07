package rotatearray;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class RotateArrayTest {


    private static RotateArray ra = new RotateArray();

    @BeforeClass
    public static void setUp() throws Exception {
        ra = new RotateArray();
    }

    @Test
    public void case0() {
        int[] testCase = {1,2,3,4,5,6,7};
        int[] expectedCase = {5,6,7,1,2,3,4};
        ra.rotate(testCase, 3);
        Assert.assertArrayEquals(expectedCase, testCase);
    }
    

    @Test
    public void case1() {
        int[] testCase = {-1,-100,3,99};
        int[] expectedCase = {3,99,-1,-100};
        ra.rotate(testCase, 2);
        Assert.assertArrayEquals(expectedCase, testCase);
    }

}