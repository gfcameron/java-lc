package largestuniquenumber;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LargestUniqueNumberTest {

    private static LargestUniqueNumber lun;

    @BeforeClass
    public static void setUp() throws Exception {
        lun = new LargestUniqueNumber();
    }

    @Test
    public void case0() {
        int[] testCase = { 5, 7, 3, 9, 4, 9, 8, 3, 1 };
        int result = lun.largestUniqueNumber(testCase);
        Assert.assertEquals(8, result);
    }

    @Test
    public void case1() {
        int[] testCase = { 9, 9, 8, 8 };
        int result = lun.largestUniqueNumber(testCase);
        Assert.assertEquals(-1, result);
    }

}