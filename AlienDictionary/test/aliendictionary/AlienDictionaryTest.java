package aliendictionary;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class AlienDictionaryTest {



    private static AlienDictionary ad;

    @BeforeClass
    public static void setUp() throws Exception {
        ad = new AlienDictionary();
    }

    @Test
    public void case0() {
        AlienDictionary.Case testCase = new AlienDictionary.Case(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
        Assert.assertEquals(true, ad.isAlienSorted(testCase.words, testCase.order));
    }

    @Test
    public void case1() {
        AlienDictionary.Case testCase = new AlienDictionary.Case(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz");
        Assert.assertEquals(false, ad.isAlienSorted(testCase.words, testCase.order));
    }

}