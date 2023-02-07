package removenthnode;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class RemoveNthNodeFromEndOfListTest {

    int[] testCases = { 3, 47, 1994, 0 };

    private static RemoveNthNodeFromEndOfList remNode;

    @BeforeClass
    public static void setUp() throws Exception {
        remNode = new RemoveNthNodeFromEndOfList();
    }

    @Test
    public void case0() {
        RemoveNthNodeFromEndOfList.ListNode testCase = new RemoveNthNodeFromEndOfList.ListNode(5);
        testCase = new RemoveNthNodeFromEndOfList.ListNode(4, testCase);
        testCase = new RemoveNthNodeFromEndOfList.ListNode(3, testCase);
        testCase = new RemoveNthNodeFromEndOfList.ListNode(2, testCase);
        testCase = new RemoveNthNodeFromEndOfList.ListNode(1, testCase);

        int[] expected = new int[]{1,2,3,5};

        RemoveNthNodeFromEndOfList.ListNode result = remNode.removeNthFromEnd(testCase, 2);
        for (int i : expected) {
            Assert.assertEquals(i, result.val);
            result = result.next;
        }
        Assert.assertEquals(result, null);
    }

    @Test
    public void case1() {
        RemoveNthNodeFromEndOfList.ListNode testCase = new RemoveNthNodeFromEndOfList.ListNode(1);

        RemoveNthNodeFromEndOfList.ListNode result = remNode.removeNthFromEnd(testCase, 1);
        Assert.assertEquals(result, null);
    }

   @Test
    public void case2() {
        RemoveNthNodeFromEndOfList.ListNode testCase = new RemoveNthNodeFromEndOfList.ListNode(2);
        testCase = new RemoveNthNodeFromEndOfList.ListNode(1, testCase);

        int[] expected = new int[]{1};

        RemoveNthNodeFromEndOfList.ListNode result = remNode.removeNthFromEnd(testCase, 1);
        for (int i : expected) {
            Assert.assertEquals(i, result.val);
            result = result.next;
        }
        Assert.assertEquals(result, null);
    }

    @Test
    public void case3() {
        RemoveNthNodeFromEndOfList.ListNode testCase = new RemoveNthNodeFromEndOfList.ListNode(2);
        testCase = new RemoveNthNodeFromEndOfList.ListNode(1, testCase);

        int[] expected = new int[]{2};

        RemoveNthNodeFromEndOfList.ListNode result = remNode.removeNthFromEnd(testCase, 2);
        for (int i : expected) {
            Assert.assertEquals(i, result.val);
            result = result.next;
        }
        Assert.assertEquals(result, null);
    }
}