package reverseprefix;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReversePrefixTest {

    private static ReversePrefix rol = new ReversePrefix();

    @BeforeClass
    public static void setUp() throws Exception {
        rol = new ReversePrefix();
    }

    @Test
    public void case0() {
        String testCase = "abcdefd";
        char ch = 'd';
        String expectedCase = "dcbaefd";
        Assert.assertEquals(expectedCase, rol.reversePrefix(testCase, ch));
    }

    @Test
    public void case1() {
        String testCase = "xyxzxe";
        char ch = 'z';
        String expectedCase = "zxyxxe";
        Assert.assertEquals(expectedCase, rol.reversePrefix(testCase, ch));
    }

    @Test
    public void case2() {
        String testCase = "abcd";
        char ch = 'z';
        String expectedCase = "abcd";
        Assert.assertEquals(expectedCase, rol.reversePrefix(testCase, ch));
    }

}