package swapnodesinalinkedlist;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SwapNodesInALinkedListTest {

    private static SwapNodesInALinkedList remNode;

    @BeforeClass
    public static void setUp() throws Exception {
        remNode = new SwapNodesInALinkedList();
    }

    private void compare(SwapNodesInALinkedList.ListNode result, SwapNodesInALinkedList.ListNode expected) {
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
        SwapNodesInALinkedList.ListNode testCase = SwapNodesInALinkedList
                .buildListNodesFromList(new int[] { 1, 2, 3, 4, 5 });
        SwapNodesInALinkedList.ListNode expected = SwapNodesInALinkedList
                .buildListNodesFromList(new int[] { 1, 4, 3, 2, 5 });
        SwapNodesInALinkedList.ListNode result = remNode.swapNodes(testCase, 2);
        compare(expected, result);
    }

    @Test
    public void case1() {
        SwapNodesInALinkedList.ListNode testCase = SwapNodesInALinkedList
                .buildListNodesFromList(new int[] { 7, 9, 6, 6, 7, 8, 3, 0, 9, 5 });
        SwapNodesInALinkedList.ListNode expected = SwapNodesInALinkedList
                .buildListNodesFromList(new int[] { 7, 9, 6, 6, 8, 7, 3, 0, 9, 5 });
        SwapNodesInALinkedList.ListNode result = remNode.swapNodes(testCase, 5);
        compare(expected, result);
    }

    @Test
    public void case2() {
        SwapNodesInALinkedList.ListNode testCase = SwapNodesInALinkedList
                .buildListNodesFromList(new int[] { 1, 2 });
        SwapNodesInALinkedList.ListNode expected = SwapNodesInALinkedList
                .buildListNodesFromList(new int[] { 2, 1 });
        SwapNodesInALinkedList.ListNode result = remNode.swapNodes(testCase, 1);
        compare(expected, result);
    }

    @Test
    public void case3() {
        SwapNodesInALinkedList.ListNode testCase = SwapNodesInALinkedList
                .buildListNodesFromList(new int[] { 100, 90 });
        SwapNodesInALinkedList.ListNode expected = SwapNodesInALinkedList
                .buildListNodesFromList(new int[] { 90, 100 });
        SwapNodesInALinkedList.ListNode result = remNode.swapNodes(testCase, 2);
        compare(expected, result);
    }

}