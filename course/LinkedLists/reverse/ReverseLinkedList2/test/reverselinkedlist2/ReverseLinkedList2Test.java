package reverselinkedlist2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReverseLinkedList2Test {

    private static ReverseLinkedList2 rll2;

    @BeforeClass
    public static void setUp() throws Exception {
        rll2 = new ReverseLinkedList2();
    }

    private void compare(ReverseLinkedList2.ListNode result, ReverseLinkedList2.ListNode expected) {
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
        ReverseLinkedList2.ListNode testCase = ReverseLinkedList2.buildListNodesFromList(new int[] { 1, 2, 3, 4, 5 });
        ReverseLinkedList2.ListNode expected = ReverseLinkedList2.buildListNodesFromList(new int[] { 1, 4, 3, 2, 5 });
        ReverseLinkedList2.ListNode result = rll2.reverseBetween(testCase, 2, 4);
        compare(expected, result);
    }

    @Test
    public void case1() {
        ReverseLinkedList2.ListNode testCase = ReverseLinkedList2.buildListNodesFromList(new int[] { 5 });
        ReverseLinkedList2.ListNode expected = ReverseLinkedList2.buildListNodesFromList(new int[] { 5 });
        ReverseLinkedList2.ListNode result = rll2.reverseBetween(testCase, 1, 1);
        compare(expected, result);
    }

    @Test
    public void case2() {
        ReverseLinkedList2.ListNode testCase = ReverseLinkedList2.buildListNodesFromList(new int[] { 3, 5 });
        ReverseLinkedList2.ListNode expected = ReverseLinkedList2.buildListNodesFromList(new int[] { 5, 3 });
        ReverseLinkedList2.ListNode result = rll2.reverseBetween(testCase, 1, 2);
        compare(expected, result);
    }

    @Test
    public void case3() {
        ReverseLinkedList2.ListNode testCase = ReverseLinkedList2.buildListNodesFromList(new int[] { 3, 5 });
        ReverseLinkedList2.ListNode expected = ReverseLinkedList2.buildListNodesFromList(new int[] { 3, 5 });
        ReverseLinkedList2.ListNode result = rll2.reverseBetween(testCase, 1, 1);
        compare(expected, result);
    }

    @Test
    public void case4() {
        ReverseLinkedList2.ListNode testCase = ReverseLinkedList2.buildListNodesFromList(new int[] { 1, 2, 3 });
        ReverseLinkedList2.ListNode expected = ReverseLinkedList2.buildListNodesFromList(new int[] { 2, 1, 3 });
        ReverseLinkedList2.ListNode result = rll2.reverseBetween(testCase, 1, 2);
        compare(expected, result);
    }

    @Test
    public void case5() {
        ReverseLinkedList2.ListNode testCase = ReverseLinkedList2.buildListNodesFromList(new int[] { 1, 2, 3, 4, 5 });
        ReverseLinkedList2.ListNode expected = ReverseLinkedList2.buildListNodesFromList(new int[] { 1, 2, 4, 3, 5 });
        ReverseLinkedList2.ListNode result = rll2.reverseBetween(testCase, 3, 4);
        compare(expected, result);
    }

}