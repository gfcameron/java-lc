package roman;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class IntToRomanTest {

    int[] testCases = { 3, 47, 1994, 0 };

    private static IntToRoman rconv;

    @BeforeClass
    public static void setUp() throws Exception {
        rconv = new IntToRoman();
    }

    @Test
    public void case0() {
        Assert.assertEquals("III", rconv.isValid(3));
    }

    @Test
    public void case1() {
        Assert.assertEquals("LVII", rconv.isValid(57));
    }

   @Test
    public void case2() {
        Assert.assertEquals("MCMXCIV", rconv.isValid(1994));
    }

    @Test
    public void case3() {
        Assert.assertEquals("", rconv.isValid(0));
    }

}