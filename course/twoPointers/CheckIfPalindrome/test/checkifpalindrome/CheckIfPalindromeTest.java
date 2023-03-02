package checkifpalindrome;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CheckIfPalindromeTest {

    private static CheckIfPalindrome cip;

    @BeforeClass
    public static void setUp() throws Exception {
        cip = new CheckIfPalindrome();
    }

    @Test
    public void case0() {
        String testCase = "racecar";
        boolean result = cip.checkIfPalindrome(testCase);
        Assert.assertTrue(result);
    }

    @Test
    public void case1() {
        String testCase = "abba";
        boolean result = cip.checkIfPalindrome(testCase);
        Assert.assertTrue(result);
    }

    @Test
    public void case2() {
        String testCase = "boulder";
        boolean result = cip.checkIfPalindrome(testCase);
        Assert.assertFalse(result);
    }

}