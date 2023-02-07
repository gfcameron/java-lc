package longestsubstr;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class LongestSubStringTest {


    private static LongestSubstr lss = new LongestSubstr();

    @BeforeClass
    public static void setUp() throws Exception {
        lss = new LongestSubstr();
    }

    @Test
    public void case0() {
        String testCase = "abcabcbb";
        Assert.assertEquals(3,  lss.lengthOfLongestSubstring(testCase));
    }

    @Test
    public void case1() {
        String testCase = "bbbbb";
        Assert.assertEquals(1,  lss.lengthOfLongestSubstring(testCase));
    }

    @Test
    public void case2() {
        String testCase = "pwwkew";
        Assert.assertEquals(3,  lss.lengthOfLongestSubstring(testCase));
    }

    @Test
    public void case3() {
        String testCase = "x";
        Assert.assertEquals(1,  lss.lengthOfLongestSubstring(testCase));
    }

    @Test
    public void case4() {
        String testCase = "";
        Assert.assertEquals(0,  lss.lengthOfLongestSubstring(testCase));
    }

    @Test
    public void case5() {
        String testCase = "abcdef";
        lss.lengthOfLongestSubstring(testCase);
        Assert.assertEquals(6,  lss.lengthOfLongestSubstring(testCase));
    }
}