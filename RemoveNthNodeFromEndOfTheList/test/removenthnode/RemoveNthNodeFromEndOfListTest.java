package removenthnode;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {

    private static RemoveNthNodeFromEndOfList remNode;

    @BeforeClass
    public static void setUp() throws Exception {
        remNode = new RemoveNthNodeFromEndOfList();
    }

    private void compare(RemoveNthNodeFromEndOfList.ListNode result, RemoveNthNodeFromEndOfList.ListNode expected) {
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
        RemoveNthNodeFromEndOfList.ListNode testCase = RemoveNthNodeFromEndOfList
                .buildListNodesFromList(new int[] { 1, 2, 3, 4, 5 });
        RemoveNthNodeFromEndOfList.ListNode expected = RemoveNthNodeFromEndOfList
                .buildListNodesFromList(new int[] { 1, 2, 3, 5 });
        RemoveNthNodeFromEndOfList.ListNode result = remNode.removeNthFromEnd(testCase, 2);
        compare(expected, result);
    }

    @Test
    public void case1() {
        RemoveNthNodeFromEndOfList.ListNode testCase = RemoveNthNodeFromEndOfList
                .buildListNodesFromList(new int[] { 1 });
        RemoveNthNodeFromEndOfList.ListNode expected = RemoveNthNodeFromEndOfList.buildListNodesFromList(new int[] {});

        RemoveNthNodeFromEndOfList.ListNode result = remNode.removeNthFromEnd(testCase, 1);
        compare(expected, result);
    }

    @Test
    public void case2() {
        RemoveNthNodeFromEndOfList.ListNode testCase = RemoveNthNodeFromEndOfList
                .buildListNodesFromList(new int[] { 1, 2 });
        RemoveNthNodeFromEndOfList.ListNode expected = RemoveNthNodeFromEndOfList
                .buildListNodesFromList(new int[] { 1 });

        RemoveNthNodeFromEndOfList.ListNode result = remNode.removeNthFromEnd(testCase, 1);
        compare(expected, result);
    }

    @Test
    public void case3() {
        RemoveNthNodeFromEndOfList.ListNode testCase = RemoveNthNodeFromEndOfList
                .buildListNodesFromList(new int[] { 1, 2 });
        RemoveNthNodeFromEndOfList.ListNode expected = RemoveNthNodeFromEndOfList
                .buildListNodesFromList(new int[] { 2 });

        RemoveNthNodeFromEndOfList.ListNode result = remNode.removeNthFromEnd(testCase, 2);
        compare(expected, result);
    }
}