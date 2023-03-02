package maxavgsubarray1;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaxAvgSubArray1Test {

    private static NaxAvgSubArray1 masa;

    @BeforeClass
    public static void setUp() throws Exception {
        masa = new NaxAvgSubArray1();
    }

    @Test
    public void case0() {
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        double result = masa.findMaxAverage(nums, k);
        Assert.assertTrue(Math.abs(result - 12.75000) < 0.001);
    }
}