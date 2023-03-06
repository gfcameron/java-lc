package findluckyintegerinarray;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindLuckyIntegerInArrayTest {

    private static FindLuckyIntegerInArray fli;

    @BeforeClass
    public static void setUp() throws Exception {
        fli = new FindLuckyIntegerInArray();
    }

    @Test
    public void case0() {
        int[] testCase = { 2, 2, 3, 4 };
        int result = fli.findLucky(testCase);
        Assert.assertEquals(2, result);
    }

    @Test
    public void case1() {
        int[] testCase = { 1, 2, 2, 3, 3, 3 };
        int result = fli.findLucky(testCase);
        Assert.assertEquals(3, result);
    }

    @Test
    public void case2() {
        int[] testCase = { 2, 2, 2, 3, 3 };
        int result = fli.findLucky(testCase);
        Assert.assertEquals(-1, result);
    }

}