package checkfortarget;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CheckForTargetTest {

    private static CheckForTarget cft = new CheckForTarget();

    @BeforeClass
    public static void setUp() throws Exception {
        cft = new CheckForTarget();
    }

    @Test
    public void case0() {
        int[] nums = { 1, 2, 4, 6, 8, 9, 14, 15 };
        int target = 13;
        boolean result = cft.checkForTarget(nums, target);
        Assert.assertTrue(result);
    }
}