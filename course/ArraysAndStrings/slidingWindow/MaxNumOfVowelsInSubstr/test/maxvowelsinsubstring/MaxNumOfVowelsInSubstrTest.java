package maxvowelsinsubstring;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaxNumOfVowelsInSubstrTest {

    private static MaxNumOfVowelsInSubstr mv;

    @BeforeClass
    public static void setUp() throws Exception {
        mv = new MaxNumOfVowelsInSubstr();
    }

    @Test
    public void case0() {
        String s = "abciiidef";
        int k = 3;
        int result = mv.maxVowels(s, k);
        Assert.assertEquals(3, result);
    }

    @Test
    public void case1() {
        String s = "aeiou";
        int k = 2;
        int result = mv.maxVowels(s, k);
        Assert.assertEquals(2, result);
    }

    @Test
    public void case2() {
        String s = "leetcode";
        int k = 3;
        int result = mv.maxVowels(s, k);
        Assert.assertEquals(2, result);
    }

    @Test
    public void case3() {
        String s = "rhythms";
        int k = 4;
        int result = mv.maxVowels(s, k);
        Assert.assertEquals(0, result);
    }

}