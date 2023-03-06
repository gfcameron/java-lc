package sortcharsbyfrequency;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortCharsByFrequencyTest {

    private static SortCharsByFrequency fs;

    @BeforeClass
    public static void setUp() throws Exception {
        fs = new SortCharsByFrequency();
    }

    @Test
    public void case0() {
        String testCase = "tree";
        String expected = "eert";
        String result = fs.frequencySort(testCase);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void case1() {
        String testCase = "cccaaa";
        String expected = "aaaccc";
        String result = fs.frequencySort(testCase);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void case2() {
        String testCase = "Aabb";
        String expected = "bbAa";
        String result = fs.frequencySort(testCase);
        Assert.assertEquals(expected, result);
    }

}