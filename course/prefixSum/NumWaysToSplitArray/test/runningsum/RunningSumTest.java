package runningsum;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RunningSumTest {

    private static RunningSum rs;

    @BeforeClass
    public static void setUp() throws Exception {
        rs = new RunningSum();
    }

    @Test
    public void case0() {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = rs.runningSum(nums);
        Assert.assertArrayEquals(new int[] { 1, 3, 6, 10 }, result);
    }

    @Test
    public void case1() {
        int[] nums = { 1, 1, 1, 1, 1 };
        int[] result = rs.runningSum(nums);
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, result);
    }

    @Test
    public void case2() {
        int[] nums = { 3, 1, 2, 10, 1 };
        int[] result = rs.runningSum(nums);
        Assert.assertArrayEquals(new int[] { 3, 4, 6, 16, 17 }, result);
    }

}