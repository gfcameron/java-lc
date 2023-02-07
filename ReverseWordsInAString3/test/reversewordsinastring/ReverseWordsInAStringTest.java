package reversewordsinastring;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class ReverseWordsInAStringTest {


    private static ReverseWordsInAString rs = new ReverseWordsInAString();

    @BeforeClass
    public static void setUp() throws Exception {
        rs = new ReverseWordsInAString();
    }

    @Test
    public void case0() {
        String testCase = "Let's take LeetCode contest";
        String expectedCase = "s'teL ekat edoCteeL tsetnoc";
        Assert.assertTrue(expectedCase.compareTo(rs.reverseWords(testCase))==0);
    }
    

    @Test
    public void case1() {
        String testCase = "God Ding";
        String expectedCase = "doG gniD";
        Assert.assertEquals(expectedCase,rs.reverseWords(testCase));
    }

    @Test
    public void case2() {
        String testCase = "X";
        String expectedCase = "X";
        Assert.assertEquals(expectedCase,rs.reverseWords(testCase));
    }

}