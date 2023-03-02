package minvaltogetposstepbystepsum;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MinValToGetPosStepByStepSumTest {

    private static MinValToGetPosStepByStepSum msv;

    @BeforeClass
    public static void setUp() throws Exception {
        msv = new MinValToGetPosStepByStepSum();
    }

    @Test
    public void case0() {
        int[] nums = { -3, 2, -3, 4, 2 };
        int result = msv.minStartValue(nums);
        Assert.assertEquals(5, result);
    }

    @Test
    public void case1() {
        int[] nums = { 1, 2 };
        int result = msv.minStartValue(nums);
        Assert.assertEquals(1, result);
    }

    @Test
    public void case2() {
        int[] nums = { 1, -2, -3 };
        int result = msv.minStartValue(nums);
        Assert.assertEquals(5, result);
    }

}