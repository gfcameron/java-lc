package finddup;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class FindDuplicateNumTest {

    private static FindDuplicateNum fd;

    @BeforeClass
    public static void setUp() throws Exception {
        fd = new FindDuplicateNum();
    }

    @Test
    public void case0() {
        int[] testCase0 = {1,3,4,2,2};
        Assert.assertEquals(2, fd.findDuplicateNum(testCase0));
    }

    @Test
    public void case1() {
        int[] testCase1 = {3,1,3,4,2};
        Assert.assertEquals(3, fd.findDuplicateNum(testCase1));
    }

   @Test
    public void case2() {
        int[] testCase2 = {1,2,3,4,5};
        Assert.assertEquals(Integer.MIN_VALUE, fd.findDuplicateNum(testCase2));
    }
}