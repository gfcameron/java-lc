package isomorphicstrings;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class IsomorphicStringsTest {

    private static IsomorphicStrings is;

    @BeforeClass
    public static void setUp() throws Exception {
        is = new IsomorphicStrings();
    }

    @Test
    public void case0() {
        String s = "egg";
        String t = "add";
        boolean result = is.isIsomorphic(s, t);
        Assert.assertTrue(result);
    }

    @Test
    public void case1() {
        String s = "foo";
        String t = "bar";
        boolean result = is.isIsomorphic(s, t);
        Assert.assertFalse(result);
    }

    @Test
    public void case2() {
        String s = "paper";
        String t = "title";
        boolean result = is.isIsomorphic(s, t);
        Assert.assertTrue(result);
    }

    @Test
    public void case3() {
        String s = "badc";
        String t = "baba";
        boolean result = is.isIsomorphic(s, t);
        Assert.assertTrue(result);
    }

}