package numberofnicesubarrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumberOfNiceSubarraysTest {

    private static NumberOfNiceSubarrays nnsa;

    @BeforeClass
    public static void setUp() throws Exception {
        nnsa = new NumberOfNiceSubarrays();
    }

    @Test
    public void case0() {
        int[] testCase = { 1, 1, 2, 1, 1 };
        int k = 3;
        int result = nnsa.numberOfSubarrays(testCase, k);
        Assert.assertEquals(2, result);
    }

    @Test
    public void case1() {
        int[] testCase = { 2, 4, 6 };
        int k = 1;
        int result = nnsa.numberOfSubarrays(testCase, k);
        Assert.assertEquals(0, result);
    }

    @Test
    public void case2() {
        int[] testCase = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int k = 2;
        int result = nnsa.numberOfSubarrays(testCase, k);
        Assert.assertEquals(16, result);
    }

}