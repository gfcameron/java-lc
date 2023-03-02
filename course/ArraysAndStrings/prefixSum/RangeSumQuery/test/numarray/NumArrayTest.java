package numarray;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumArrayTest {

    private static NumArray na;

    @BeforeClass
    public static void setUp() throws Exception {
    }

    @Test
    public void case0() {
        na = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
        int result = na.sumRange(0, 2);
        Assert.assertEquals(1, result);
        result = na.sumRange(2, 5);
        Assert.assertEquals(-1, result);
        result = na.sumRange(0, 5);
        Assert.assertEquals(-3, result);
    }
}