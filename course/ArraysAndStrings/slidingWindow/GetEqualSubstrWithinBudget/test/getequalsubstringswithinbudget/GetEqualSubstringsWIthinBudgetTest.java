package getequalsubstringswithinbudget;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetEqualSubstringsWIthinBudgetTest {

    private static GetEqualSubstringsWithinBudget ges;

    @BeforeClass
    public static void setUp() throws Exception {
        ges = new GetEqualSubstringsWithinBudget();
    }

    @Test
    public void case0() {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int result = ges.equalSubstring(s, t, maxCost);
        Assert.assertEquals(3, result);
    }

    @Test
    public void case1() {
        String s = "abcd";
        String t = "cdef";
        int maxCost = 3;
        int result = ges.equalSubstring(s, t, maxCost);
        Assert.assertEquals(1, result);
    }

    @Test
    public void case2() {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 1;
        int result = ges.equalSubstring(s, t, maxCost);
        Assert.assertEquals(1, result);
    }
}