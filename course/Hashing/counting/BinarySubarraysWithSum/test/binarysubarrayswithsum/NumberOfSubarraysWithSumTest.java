package binarysubarrayswithsum;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumberOfSubarraysWithSumTest {

    private static NumberOfSubarraysWithSum nsa;

    @BeforeClass
    public static void setUp() throws Exception {
        nsa = new NumberOfSubarraysWithSum();
    }

    @Test
    public void case0() {
        int[] testCase = { 1, 0, 1, 0, 1 };
        int goal = 2;
        int result = nsa.numberOfSubarraysWithSum(testCase, goal);
        Assert.assertEquals(2, result);
    }

    @Test
    public void case1() {
        int[] testCase = { 0, 0, 0, 0, 0 };
        int goal = 0;
        int result = nsa.numberOfSubarraysWithSum(testCase, goal);
        Assert.assertEquals(15, result);
    }

}