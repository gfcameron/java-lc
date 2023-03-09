package maxtwinsumoflinkedlist;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaxTwinSumOfLinkedListTest {

    private static MaxTwinSumOfLinkedList mt;

    @BeforeClass
    public static void setUp() throws Exception {
        mt = new MaxTwinSumOfLinkedList();
    }

    @Test
    public void case0() {
        MaxTwinSumOfLinkedList.ListNode testCase = MaxTwinSumOfLinkedList
                .buildListNodesFromList(new int[] { 5, 4, 2, 1 });
        int result = mt.pairSum(testCase);
        Assert.assertEquals(6, result);
    }

    @Test
    public void case1() {
        MaxTwinSumOfLinkedList.ListNode testCase = MaxTwinSumOfLinkedList
                .buildListNodesFromList(new int[] { 4, 2, 2, 3 });
        int result = mt.pairSum(testCase);
        Assert.assertEquals(7, result);
    }

    @Test
    public void case2() {
        MaxTwinSumOfLinkedList.ListNode testCase = MaxTwinSumOfLinkedList
                .buildListNodesFromList(new int[] { 1, 100000 });
        int result = mt.pairSum(testCase);
        Assert.assertEquals(100001, result);
    }
}