package areoccurencesequal;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AreOccurencesEqualTest {

    private static AreOccurencesEqual aoe;

    @BeforeClass
    public static void setUp() throws Exception {
        aoe = new AreOccurencesEqual();
    }

    @Test
    public void case0() {
        String testCase = "abacbc";
        boolean result = aoe.areOccurrencesEqual(testCase);
        Assert.assertTrue(result);
    }

    @Test
    public void case1() {
        String testCase = "abcdef";
        boolean result = aoe.areOccurrencesEqual(testCase);
        Assert.assertTrue(result);
    }

    @Test
    public void case2() {
        String testCase = "aabbaa";
        boolean result = aoe.areOccurrencesEqual(testCase);
        Assert.assertFalse(result);
    }

}