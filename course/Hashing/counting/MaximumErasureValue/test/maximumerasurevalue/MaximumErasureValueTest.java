package maximumerasurevalue;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaximumErasureValueTest {

    private static MaximumErasureValue mev;

    @BeforeClass
    public static void setUp() throws Exception {
        mev = new MaximumErasureValue();
    }

    @Test
    public void case0() {
        int[] testCase = { 4, 2, 4, 5, 6 };
        int result = mev.maximumUniqueSubarray(testCase);
        Assert.assertEquals(17, result);
    }

    @Test
    public void case1() {
        int[] testCase = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };
        int result = mev.maximumUniqueSubarray(testCase);
        Assert.assertEquals(8, result);
    }

}