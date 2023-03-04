package intersection;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class IntersectionOfMultipleArraysTest {

    private static IntersectionOfMultipleArrays ima;

    @BeforeClass
    public static void setUp() throws Exception {
        ima = new IntersectionOfMultipleArrays();
    }

    @Test
    public void case0() {
        int[][] testCase = {
                { 3, 1, 2, 4, 5 },
                { 1, 2, 3, 4 },
                { 3, 4, 5, 6 },
        };
        int[] expected = { 3, 4 };
        List<Integer> result = ima.intersection(testCase);
        Assert.assertArrayEquals(expected, result.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void case1() {
        int[][] testCase = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
        };
        int[] expected = {};
        List<Integer> result = ima.intersection(testCase);
        Assert.assertArrayEquals(expected, result.stream().mapToInt(i -> i).toArray());
    }
}