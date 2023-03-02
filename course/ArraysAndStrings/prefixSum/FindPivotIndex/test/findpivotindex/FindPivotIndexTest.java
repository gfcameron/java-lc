package findpivotindex;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindPivotIndexTest {

    private static FindPivotIndex pi;

    @BeforeClass
    public static void setUp() throws Exception {
        pi = new FindPivotIndex();
    }

    @Test
    public void case0() {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        int result = pi.pivotIndex(nums);
        Assert.assertEquals(3, result);
    }

    @Test
    public void case1() {
        int[] nums = { 1, 2, 3 };
        int result = pi.pivotIndex(nums);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void case2() {
        int[] nums = { 2, 1, -1 };
        int result = pi.pivotIndex(nums);
        Assert.assertEquals(0, result);
    }

    @Test
    public void case3() {
        int[] nums = { -1, -1, 0, 1, 0, -1 };
        int result = pi.pivotIndex(nums);
        Assert.assertEquals(4, result);
    }

    @Test
    public void case4() {
        int[] nums = { -1, -1, 0, 1, 1, 0 };
        int result = pi.pivotIndex(nums);
        Assert.assertEquals(5, result);
    }

}