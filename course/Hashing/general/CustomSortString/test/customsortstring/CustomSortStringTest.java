package customsortstring;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomSortStringTest {

    private static CustomSortString css;

    @BeforeClass
    public static void setUp() throws Exception {
        css = new CustomSortString();
    }

    @Test
    public void case0() {
        String order = "cba";
        String s = "abcd";
        String expected = "cbad";
        String result = css.customSortString(order, s);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void case1() {
        String order = "cbafg";
        String s = "abcd";
        String expected = "cbad";
        String result = css.customSortString(order, s);
        Assert.assertEquals(expected, result);
    }

    public void case2() {
        String order = "kqep";
        String s = "pekeq";
        String expected = "kqeep";
        String result = css.customSortString(order, s);
        Assert.assertEquals(expected, result);
    }

}