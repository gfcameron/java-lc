package searchinsertpos;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class SearchInsertPositionTest {


    private static SearchInsertPosition sip;

    @BeforeClass
    public static void setUp() throws Exception {
        sip = new SearchInsertPosition();
    }

    @Test
    public void case0() {
        Assert.assertEquals(2, sip.searchInsert(new int[]{1,3,5,6}, 5));
    }

    @Test
    public void case1() {
        Assert.assertEquals(1, sip.searchInsert(new int[]{1,3,5,6}, 2));
    }

    @Test
    public void case2() {
        Assert.assertEquals(4, sip.searchInsert(new int[]{1,3,5,6}, 7));
    }

    @Test
    public void case3() {
        Assert.assertEquals(0, sip.searchInsert(new int[]{1,3,5,6}, 0));
    }

    @Test
    public void case4() {
        Assert.assertEquals(0, sip.searchInsert(new int[]{1,3,5,6}, 1));
    }

    @Test
    public void case5() {
        Assert.assertEquals(3, sip.searchInsert(new int[]{1,3,5,6}, 6));
    }

    @Test
    public void case6() {
        Assert.assertEquals(2, sip.searchInsert(new int[]{1,3,5,6,7}, 5));
    }

    @Test
    public void case7() {
        Assert.assertEquals(1, sip.searchInsert(new int[]{1,3,5,6,7}, 2));
    }

    @Test
    public void case8() {
        Assert.assertEquals(5, sip.searchInsert(new int[]{1,3,5,6,7}, 8));
    }

    @Test
    public void case9() {
        Assert.assertEquals(0, sip.searchInsert(new int[]{-1,0}, -2));
    }

    @Test
    public void case10() {
        Assert.assertEquals(0, sip.searchInsert(new int[]{-1,0}, -1));
    }

    @Test
    public void case11() {
        Assert.assertEquals(1, sip.searchInsert(new int[]{-1,0}, 0));
    }

    @Test
    public void case12() {
        Assert.assertEquals(2, sip.searchInsert(new int[]{-1,0}, 9));
    }

    @Test
    public void case13() {
        Assert.assertEquals(0, sip.searchInsert(new int[]{-1}, -2));
    }

    @Test
    public void case14() {
        Assert.assertEquals(0, sip.searchInsert(new int[]{-1}, -1));
    }

    @Test
    public void case15() {
        Assert.assertEquals(1, sip.searchInsert(new int[]{-1}, 0));
    }

    @Test
    public void case16() {
        Assert.assertEquals(1, sip.searchInsert(new int[]{-1}, 9));
    }

    @Test
    public void case17() {
        Assert.assertEquals(1, sip.searchInsert(new int[]{1, 3}, 2));
    }

}