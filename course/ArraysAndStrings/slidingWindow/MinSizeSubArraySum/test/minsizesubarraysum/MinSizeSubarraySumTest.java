package minsizesubarraysum;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MinSizeSubarraySumTest {

    private static MinSizeSubarraySum mssa;

    @BeforeClass
    public static void setUp() throws Exception {
        mssa = new MinSizeSubarraySum();
    }

    @Test
    public void case0() {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        int result = mssa.minSubArrayLen(target, nums);
        Assert.assertEquals(2, result);
    }

    @Test
    public void case1() {
        int[] nums = { 1, 4, 4 };
        int target = 4;
        int result = mssa.minSubArrayLen(target, nums);
        Assert.assertEquals(1, result);
    }

    @Test
    public void case2() {
        int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1 };
        int target = 11;
        int result = mssa.minSubArrayLen(target, nums);
        Assert.assertEquals(0, result);
    }

    @Test
    public void case3() {
        int[] nums = { 2, 3, 1, 1, 1, 1, 1 };
        int target = 5;
        int result = mssa.minSubArrayLen(target, nums);
        Assert.assertEquals(2, result);
    }

}