package numberofgoodpairs;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumberOfGoodPairsTest {

    private static NumberOfGoodPairs ngp;

    @BeforeClass
    public static void setUp() throws Exception {
        ngp = new NumberOfGoodPairs();
    }

    @Test
    public void case0() {
        int[] testCase = { 1, 2, 3, 1, 1, 3 };
        int result = ngp.numIdenticalPairs(testCase);
        Assert.assertEquals(4, result);
    }

    @Test
    public void case1() {
        int[] testCase = { 1, 1, 1, 1 };
        int result = ngp.numIdenticalPairs(testCase);
        Assert.assertEquals(6, result);
    }

    @Test
    public void case2() {
        int[] testCase = { 1, 2, 3 };
        int result = ngp.numIdenticalPairs(testCase);
        Assert.assertEquals(0, result);
    }

}