package sumofuniqueelements;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SumOfUniqueElementsTest {

    private static SumOfUniqueElements sue;

    @BeforeClass
    public static void setUp() throws Exception {
        sue = new SumOfUniqueElements();
    }

    @Test
    public void case0() {
        int[] testCase = { 1, 2, 3, 2 };
        int result = sue.sumOfUnique(testCase);
        Assert.assertEquals(4, result);
    }

    @Test
    public void case1() {
        int[] testCase = { 1, 1, 1, 1, 1 };
        int result = sue.sumOfUnique(testCase);
        Assert.assertEquals(0, result);
    }

    @Test
    public void case2() {
        int[] testCase = { 1, 2, 3, 4, 5 };
        int result = sue.sumOfUnique(testCase);
        Assert.assertEquals(15, result);
    }

}