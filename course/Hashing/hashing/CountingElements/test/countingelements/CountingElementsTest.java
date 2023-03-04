package countingelements;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountingElementsTest {

    private static CountingElements ce;

    @BeforeClass
    public static void setUp() throws Exception {
        ce = new CountingElements();
    }

    @Test
    public void case0() {
        int[] testCase = { 1, 2, 3 };
        int result = ce.countElements(testCase);
        Assert.assertEquals(2, result);
    }

    @Test
    public void case1() {
        int[] testCase = { 1, 1, 3, 3, 5, 5, 7, 7 };
        int result = ce.countElements(testCase);
        Assert.assertEquals(0, result);
    }
}