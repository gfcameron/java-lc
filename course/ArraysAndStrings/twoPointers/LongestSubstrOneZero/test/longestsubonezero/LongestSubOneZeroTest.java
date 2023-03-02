package longestsubonezero;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LongestSubOneZeroTest {

    private static LongestSubOneZero ls;

    @BeforeClass
    public static void setUp() throws Exception {
        ls = new LongestSubOneZero();
    }

    @Test
    public void case0() {
        String testCase = "1101100111";
        int result = ls.findLength(testCase);
        Assert.assertEquals(result, 5);
    }

    @Test
    public void case1() {
        String testCase = "1";
        int result = ls.findLength(testCase);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void case2() {
        String testCase = "0";
        int result = ls.findLength(testCase);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void case3() {
        String testCase = "";
        int result = ls.findLength(testCase);
        Assert.assertEquals(result, 0);
    }

}