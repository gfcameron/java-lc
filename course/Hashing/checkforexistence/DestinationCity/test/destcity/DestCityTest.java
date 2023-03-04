package destcity;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DestCityTest {

    private static DestCity dc;

    @BeforeClass
    public static void setUp() throws Exception {
        dc = new DestCity();
    }

    @Test
    public void case0() {
        List<List<String>> testCase = List.of(
                List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo"));
        String expected = "Sao Paulo";

        String result = dc.destCity(testCase);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void case1() {
        List<List<String>> testCase = List.of(
                List.of("B", "C"),
                List.of("D", "B"),
                List.of("C", "A"));
        String expected = "A";

        String result = dc.destCity(testCase);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void case2() {
        List<List<String>> testCase = List.of(
                List.of("A", "Z"));
        String expected = "Z";

        String result = dc.destCity(testCase);
        Assert.assertEquals(expected, result);
    }

}