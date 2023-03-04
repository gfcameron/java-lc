package findlongestsubstr;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindLongestSubstrTest {

    private static FindLongestSubstr rc;

    @BeforeClass
    public static void setUp() throws Exception {
        rc = new FindLongestSubstr();
    }

    @Test
    public void case0() {
        String s = "eceba";
        int result = rc.findLongestSubstring(s, 2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void case1() {
        String s = "abccbaacz";
        int result = rc.findLongestSubstring(s, 2);
        Assert.assertEquals(4, result);
    }

    @Test
    public void case2() {
        String s = "abcdd";
        int result = rc.findLongestSubstring(s, 2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void case3() {
        String s = "abcdeda";
        int result = rc.findLongestSubstring(s, 2);
        Assert.assertEquals(3, result);
    }

}