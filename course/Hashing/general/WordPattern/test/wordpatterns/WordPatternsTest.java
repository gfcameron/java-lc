package wordpatterns;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WordPatternsTest {

    private static WordPatterns wp;

    @BeforeClass
    public static void setUp() throws Exception {
        wp = new WordPatterns();
    }

    @Test
    public void case0() {
        String s = "abba";
        String t = "dog cat cat dog";
        boolean result = wp.wordPattern(s, t);
        Assert.assertTrue(result);
    }

    @Test
    public void case1() {
        String s = "abba";
        String t = "dog cat cat fish";
        boolean result = wp.wordPattern(s, t);
        Assert.assertFalse(result);
    }

    @Test
    public void case2() {
        String s = "aaaa";
        String t = "dog cat cat dog";
        boolean result = wp.wordPattern(s, t);
        Assert.assertFalse(result);
    }

    @Test
    public void case3() {
        String s = "abba";
        String t = "dog dog dog dog";
        boolean result = wp.wordPattern(s, t);
        Assert.assertFalse(result);
    }

    @Test
    public void case4() {
        String s = "aaa";
        String t = "aa aa aa aa";
        boolean result = wp.wordPattern(s, t);
        Assert.assertFalse(result);
    }

}