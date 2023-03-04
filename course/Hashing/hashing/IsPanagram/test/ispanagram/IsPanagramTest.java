package ispanagram;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class IsPanagramTest {

    private static IsPanagram ispana;

    @BeforeClass
    public static void setUp() throws Exception {
        ispana = new IsPanagram();
    }

    @Test
    public void case0() {
        String testCase = "thequickbrownfoxjumpsoverthelazydog";
        boolean result = ispana.checkIfPangram(testCase);
        Assert.assertTrue(result);
    }

    @Test
    public void case1() {
        String testCase = "leetcode";
        boolean result = ispana.checkIfPangram(testCase);
        Assert.assertFalse(result);
    }

    @Test
    public void case2() {
        String testCase = "nowisthetimeforallgoodmentocometotheaidoftheparty";
        boolean result = ispana.checkIfPangram(testCase);
        Assert.assertFalse(result);
    }

}