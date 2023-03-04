package subarraysumequalsk;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubarraySumEqualsKTest {

    private static SubarraySumEqualsK sas;

    @BeforeClass
    public static void setUp() throws Exception {
        sas = new SubarraySumEqualsK();
    }

    @Test
    public void case0() {
        int[] testCase = { 1, 1, 1 };
        int k = 2;
        int result = sas.subarraySum(testCase, k);
        Assert.assertEquals(2, result);
    }

    @Test
    public void case1() {
        int[] testCase = { 1, 1, 1 };
        int k = 2;
        int result = sas.subarraySum(testCase, k);
        Assert.assertEquals(2, result);
    }

    @Test
    public void case2() {
        int[] testCase = { 1, 2, 3 };
        int k = 3;
        int result = sas.subarraySum(testCase, k);
        Assert.assertEquals(2, result);
    }

    @Test
    public void case3() {
        int[] testCase = { 1, 2, 1, 2, 1 };
        int k = 3;
        int result = sas.subarraySum(testCase, k);
        Assert.assertEquals(4, result);
    }
}