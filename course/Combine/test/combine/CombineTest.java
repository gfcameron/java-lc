package combine;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CombineTest {

    private static Combine cmb;

    @BeforeClass
    public static void setUp() throws Exception {
        cmb = new Combine();
    }

    @Test
    public void case0() {
        int[] arr1 = new int[] { 1, 4, 7, 20 };
        int[] arr2 = new int[] { 3, 5, 6 };
        List<Integer> result = cmb.combine(arr1, arr2);
        Assert.assertArrayEquals(result.toArray(), Arrays.asList(1, 3, 4, 5, 6, 7, 20).toArray());
    }
}