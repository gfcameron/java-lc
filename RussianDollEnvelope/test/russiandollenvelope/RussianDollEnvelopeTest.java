package russiandollenvelope;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RussianDollEnvelopeTest {

    private static RussianDollEnvelope rde;
    @BeforeClass
    public static void setUp() throws Exception {
        rde = new RussianDollEnvelope();
    }

    @Test
    public void case0() {
        int[][] testCase = {{5,4},{6,4},{6,7},{2,3}};
        Assert.assertEquals(3, rde.maxEnvelopes(testCase));
    }

    @Test
    public void case1() {
        int[][] testCase = {{1,1},{1,1},{1,1}};
        Assert.assertEquals(1, rde.maxEnvelopes(testCase));
    }

    @Test
    public void case2() {
        int[][] testCase = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        Assert.assertEquals(4, rde.maxEnvelopes(testCase));
    }

}