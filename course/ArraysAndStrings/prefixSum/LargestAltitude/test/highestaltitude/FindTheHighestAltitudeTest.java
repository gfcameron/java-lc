package highestaltitude;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindTheHighestAltitudeTest {

    private static FindTheHighestAltitude ha;

    @BeforeClass
    public static void setUp() throws Exception {
        ha = new FindTheHighestAltitude();
    }

    @Test
    public void case0() {
        int[] nums = { -5, 1, 5, 0, -7 };
        int result = ha.largestAltitude(nums);
        Assert.assertEquals(1, result);
    }

    @Test
    public void case1() {
        int[] nums = { -4, -3, -2, -1, 4, 3, 2 };
        int result = ha.largestAltitude(nums);
        Assert.assertEquals(0, result);
    }

}