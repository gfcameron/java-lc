package numsubarrayprodlessthank;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumSubArrayProdLessThanKTest {

    private static NumSubArrayProdLessThanK nsa;

    @BeforeClass
    public static void setUp() throws Exception {
        nsa = new NumSubArrayProdLessThanK();
    }

    @Test
    public void case0() {
        int[] nums = { 10, 5, 2, 6 };
        int k = 100;
        int result = nsa.numSubarrayProductLessThanK(nums, k);
        Assert.assertEquals(result, 8);
    }
}