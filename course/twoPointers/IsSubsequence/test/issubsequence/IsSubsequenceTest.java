package issubsequence;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class IsSubsequenceTest {

    private static IsSubsequence iss;

    @BeforeClass
    public static void setUp() throws Exception {
        iss = new IsSubsequence();
    }

    @Test
    public void case0() {
        String str1 = "ace";
        String str2 = "abcde";
        boolean result = iss.isSubsequence(str1, str2);
        Assert.assertTrue(result);
    }

    @Test
    public void case1() {
        String str1 = "ace";
        String str2 = "abcdf";
        boolean result = iss.isSubsequence(str1, str2);
        Assert.assertFalse(result);
    }
}