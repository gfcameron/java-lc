package twostringsareclose;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwoStringsAreCloseTest {

    private static TwoStringsAreClose tsac;

    @BeforeClass
    public static void setUp() throws Exception {
        tsac = new TwoStringsAreClose();
    }

    @Test
    public void case0() {
        String order = "abc";
        String s = "bca";
        boolean result = tsac.closeStrings(order, s);
        Assert.assertTrue(result);
    }

    @Test
    public void case1() {
        String order = "a";
        String s = "aa";
        boolean result = tsac.closeStrings(order, s);
        Assert.assertFalse(result);
    }

    public void case2() {
        String order = "cabbba";
        String s = "babbccc";
        boolean result = tsac.closeStrings(order, s);
        Assert.assertTrue(result);
    }

    public void case3() {
        String order = "uau";
        String s = "ssx";
        boolean result = tsac.closeStrings(order, s);
        Assert.assertFalse(result);
    }

}