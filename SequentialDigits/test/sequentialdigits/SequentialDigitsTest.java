package sequentialdigits;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SequentialDigitsTest {

    private static SequentialDigits sd;

    @BeforeClass
    public static void setUp() throws Exception {
        sd = new SequentialDigits();
    }

    @Test
    public void case0() {
        int[] testCase = { 100, 300 };
        int[] expected = { 123, 234 };
        List<Integer> result = sd.sequentialDigits(testCase[0], testCase[1]);
        Assert.assertArrayEquals(expected, result.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void case1() {
        int[] testCase = { 1000, 1300 };
        int[] expected = { 1234, 2345, 3456, 4567, 5678, 6789, 12345 };
        List<Integer> result = sd.sequentialDigits(testCase[0], testCase[1]);
        Assert.assertArrayEquals(expected, result.stream().mapToInt(i -> i).toArray());
    }

}