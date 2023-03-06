package uniquenumberofoccurences;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UniqueNumberOfOccurrencesTest {

    private static UniqueNumberOfOccurrences uno;

    @BeforeClass
    public static void setUp() throws Exception {
        uno = new UniqueNumberOfOccurrences();
    }

    @Test
    public void case0() {
        int[] testCase = { 1, 2, 2, 1, 1, 3 };
        boolean result = uno.uniqueOccurrences(testCase);
        Assert.assertTrue(result);
    }

    @Test
    public void case1() {
        int[] testCase = { 1, 2 };
        boolean result = uno.uniqueOccurrences(testCase);
        Assert.assertFalse(result);
    }

    @Test
    public void case2() {
        int[] testCase = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        boolean result = uno.uniqueOccurrences(testCase);
        Assert.assertTrue(result);
    }

}