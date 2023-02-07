package roman;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class RomanToIntTest {

    String[] testCases = {
        "III",
        "LVII",
        "MCMXCIV"
    };

    private static RomanToInt rconv;

    @BeforeClass
    public static void setUp() throws Exception {
        rconv = new RomanToInt();
    }

    @Test
    public void case0() {
        Assert.assertEquals(3, rconv.romanToInt("III"));
    }

    @Test
    public void case1() {
        Assert.assertEquals(57, rconv.romanToInt("LVII"));
    }

   @Test
    public void case2() {
        Assert.assertEquals(1994, rconv.romanToInt("MCMXCIV"));
    }

    @Test
    public void case3() {
        Assert.assertEquals(0, rconv.romanToInt(""));
    }

}