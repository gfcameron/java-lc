package firstrepeatedchar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FirstRepeatedCharTest {

    private static FirstRepeatedChar rc;

    @BeforeClass
    public static void setUp() throws Exception {
        rc = new FirstRepeatedChar();
    }

    @Test
    public void case0() {
        String testCase = "abcdeda";
        char result = rc.repeatedCharacter(testCase);
        Assert.assertEquals('d', result);
    }

    @Test
    public void case1() {
        String testCase = "abccbaacz";
        char result = rc.repeatedCharacter(testCase);
        Assert.assertEquals('c', result);
    }

    @Test
    public void case2() {
        String testCase = "abcdd";
        char result = rc.repeatedCharacter(testCase);
        Assert.assertEquals('d', result);
    }

}