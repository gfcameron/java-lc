package missingnumber;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MissingNumberTest {

    private static MissingNumber mn;

    @BeforeClass
    public static void setUp() throws Exception {
        mn = new MissingNumber();
    }

    @Test
    public void case0() {
        int[] testCase = { 1, 3, 4, 2, 2 };
        int[] expected = {};
        List<Integer> result = mn.findNumbers(testCase);
        Assert.assertArrayEquals(expected, result.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void case1() {
        int[] testCase = { 3, 1, 6, 4, 9 };
        int[] expected = { 1, 6, 9 };
        List<Integer> result = mn.findNumbers(testCase);
        Assert.assertArrayEquals(expected, result.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void case2() {
        int[] testCase = { 0, 2, 3, 4, 5 };
        int[] expected = { 0 };
        List<Integer> result = mn.findNumbers(testCase);
        Assert.assertArrayEquals(expected, result.stream().mapToInt(i -> i).toArray());
    }

}