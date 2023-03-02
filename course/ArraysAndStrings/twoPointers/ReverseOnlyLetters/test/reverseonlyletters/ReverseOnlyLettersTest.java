package reverseonlyletters;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReverseOnlyLettersTest {

    private static ReverseOnlyLetters rol = new ReverseOnlyLetters();

    @BeforeClass
    public static void setUp() throws Exception {
        rol = new ReverseOnlyLetters();
    }

    @Test
    public void case0() {
        String testCase = "ab-cd";
        String expectedCase = "dc-ba";
        Assert.assertTrue(expectedCase.compareTo(rol.reverseOnlyLetters(testCase)) == 0);
    }

    @Test
    public void case1() {
        String testCase = "a-bC-dEf-ghIj";
        String expectedCase = "j-Ih-gfE-dCba";
        Assert.assertEquals(expectedCase, rol.reverseOnlyLetters(testCase));
    }

    @Test
    public void case2() {
        String testCase = "Test1ng-Leet=code-Q!";
        String expectedCase = "Qedo1ct-eeLg=ntse-T!";
        Assert.assertEquals(expectedCase, rol.reverseOnlyLetters(testCase));
    }

}