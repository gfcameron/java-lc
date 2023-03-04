package maxnumberofballoons;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaxNumberOfBalloonsTest {

    private static MaxNumberOfBalloons nb;

    @BeforeClass
    public static void setUp() throws Exception {
        nb = new MaxNumberOfBalloons();
    }

    @Test
    public void case0() {
        String testCase = "nlaebolko";
        int result = nb.maxNumberOfBalloons(testCase);
        Assert.assertEquals(1, result);
    }

    @Test
    public void case1() {
        String testCase = "loonbalxballpoon";
        int result = nb.maxNumberOfBalloons(testCase);
        Assert.assertEquals(2, result);
    }

    @Test
    public void case2() {
        String testCase = "leetcode";
        int result = nb.maxNumberOfBalloons(testCase);
        Assert.assertEquals(0, result);
    }

}