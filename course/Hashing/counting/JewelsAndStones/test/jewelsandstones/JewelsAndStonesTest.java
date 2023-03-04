package jewelsandstones;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class JewelsAndStonesTest {

    private static JewelsAndStones jas;

    @BeforeClass
    public static void setUp() throws Exception {
        jas = new JewelsAndStones();
    }

    @Test
    public void case0() {
        String jewels = "aA";
        String stones = "aAAbbbb";
        int result = jas.numJewelsInStones(jewels, stones);
        Assert.assertEquals(3, result);
    }

    @Test
    public void case1() {
        String jewels = "z";
        String stones = "ZZ";
        int result = jas.numJewelsInStones(jewels, stones);
        Assert.assertEquals(0, result);
    }

}