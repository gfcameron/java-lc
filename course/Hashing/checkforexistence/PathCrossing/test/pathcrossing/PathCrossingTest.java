package pathcrossing;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PathCrossingTest {

    private static PathCrossing pc;

    @BeforeClass
    public static void setUp() throws Exception {
        pc = new PathCrossing();
    }

    @Test
    public void case0() {
        String testCase = "NES";
        boolean result = pc.isPathCrossing(testCase);
        Assert.assertFalse(result);
    }

    @Test
    public void case1() {
        String testCase = "NESWW";
        boolean result = pc.isPathCrossing(testCase);
        Assert.assertTrue(result);
    }

}