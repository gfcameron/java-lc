package findbestsubarray;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindBestSubArrayTest {

    private static NumSubArrayProdLessThanK bsa;

    @BeforeClass
    public static void setUp() throws Exception {
        bsa = new NumSubArrayProdLessThanK();
    }

    @Test
    public void case0() {
        int[] nums = { 3, -1, 4, 12, -8, 5, 6 };
        int k = 4;
        int result = bsa.findBestSubarray(nums, k);
        Assert.assertEquals(result, 18);
    }
}