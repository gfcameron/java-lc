package maxconsecutive1s;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaxConsecutive1sIIITest {

    private static MaxConsecutive1sIII masa;

    @BeforeClass
    public static void setUp() throws Exception {
        masa = new MaxConsecutive1sIII();
    }

    @Test
    public void case0() {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        int result = masa.longestOnes(nums, k);
        Assert.assertEquals(6, result);
    }

    @Test
    public void case1() {
        int[] nums = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k = 3;
        int result = masa.longestOnes(nums, k);
        Assert.assertEquals(10, result);
    }

    @Test
    public void case2() {
        int[] nums = { 0, 0, 0, 1 };
        int k = 4;
        int result = masa.longestOnes(nums, k);
        Assert.assertEquals(4, result);
    }

    @Test
    public void case3() {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k = 0;
        int result = masa.longestOnes(nums, k);
        Assert.assertEquals(4, result);
    }

}