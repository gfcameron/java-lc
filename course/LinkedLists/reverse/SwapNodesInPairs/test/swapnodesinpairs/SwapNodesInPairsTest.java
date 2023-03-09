package swapnodesinpairs;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SwapNodesInPairsTest {

    private static SwapNodesInPairs sp;

    @BeforeClass
    public static void setUp() throws Exception {
        sp = new SwapNodesInPairs();
    }

    private void compare(SwapNodesInPairs.ListNode result, SwapNodesInPairs.ListNode expected) {
        while (result != null && expected != null) {
            Assert.assertEquals(result.val, expected.val);
            if (result.next == null || expected.next == null) {
                Assert.assertNull(result.next);
                Assert.assertNull(expected.next);
                break;
            }
            Assert.assertEquals(expected.val, result.val);
            result = result.next;
            expected = expected.next;
        }
    }

    @Test
    public void case0() {
        SwapNodesInPairs.ListNode testCase = SwapNodesInPairs.buildListNodesFromList(new int[] { 1, 2, 3, 4 });
        SwapNodesInPairs.ListNode expected = SwapNodesInPairs.buildListNodesFromList(new int[] { 2, 1, 4, 3 });
        SwapNodesInPairs.ListNode result = sp.swapPairs(testCase);
        compare(expected, result);
    }

    @Test
    public void case1() {
        SwapNodesInPairs.ListNode testCase = SwapNodesInPairs.buildListNodesFromList(new int[] {});
        SwapNodesInPairs.ListNode expected = SwapNodesInPairs.buildListNodesFromList(new int[] {});
        SwapNodesInPairs.ListNode result = sp.swapPairs(testCase);
        compare(expected, result);
    }

    @Test
    public void case2() {
        SwapNodesInPairs.ListNode testCase = SwapNodesInPairs.buildListNodesFromList(new int[] { 1 });
        SwapNodesInPairs.ListNode expected = SwapNodesInPairs.buildListNodesFromList(new int[] { 1 });
        SwapNodesInPairs.ListNode result = sp.swapPairs(testCase);
        compare(expected, result);
    }

}