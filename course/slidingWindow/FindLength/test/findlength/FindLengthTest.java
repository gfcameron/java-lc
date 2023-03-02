package findlength;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindLengthTest {

    private static FindLength fl;

    @BeforeClass
    public static void setUp() throws Exception {
        fl = new FindLength();
    }

    @Test
    public void case0() {
        int[] nums = { 3, 1, 2, 7, 4, 2, 1, 1, 5 };
        int k = 8;
        int result = fl.findLength(nums, k);
        Assert.assertEquals(result, 4);
    }
}