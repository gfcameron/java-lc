package reversestring;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class ReverseStringTest {


    private static ReverseString rs = new ReverseString();

    @BeforeClass
    public static void setUp() throws Exception {
        rs = new ReverseString();
    }

    @Test
    public void case0() {
        char[] testCase = {'h', 'e', 'l', 'l', 'o'};
        char[] expectedCase = {'o', 'l', 'l', 'e', 'h'};
        rs.reverseString(testCase);
        Assert.assertArrayEquals(expectedCase, testCase);
    }
    

    @Test
    public void case1() {
        char[] testCase = {'H', 'a', 'n', 'n', 'a', 'h'};
        char[] expectedCase = {'h', 'a', 'n', 'n', 'a', 'H'};
        rs.reverseString(testCase);
        Assert.assertArrayEquals(expectedCase, testCase);
    }

    @Test
    public void case2() {
        char[] testCase = {'x'};
        char[] expectedCase = {'x'};
        rs.reverseString(testCase);
        Assert.assertArrayEquals(expectedCase, testCase);
    }

}