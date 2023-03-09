package deletemiddlenode;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeleteMiddleNodeTest {

    private static DeleteMiddleNode del;

    @BeforeClass
    public static void setUp() throws Exception {
        del = new DeleteMiddleNode();
    }

    private void compare(DeleteMiddleNode.ListNode result, DeleteMiddleNode.ListNode expected) {
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
        DeleteMiddleNode.ListNode testCase = DeleteMiddleNode.buildListNodesFromList(new int[] { 1, 3, 4, 7, 1, 2, 6 });
        DeleteMiddleNode.ListNode expected = DeleteMiddleNode.buildListNodesFromList(new int[] { 1, 3, 4, 1, 2, 6 });
        DeleteMiddleNode.ListNode result = del.deleteMiddle(testCase);
        compare(expected, result);
    }

    @Test
    public void case1() {
        DeleteMiddleNode.ListNode testCase = DeleteMiddleNode.buildListNodesFromList(new int[] { 1, 2, 3, 4 });
        DeleteMiddleNode.ListNode expected = DeleteMiddleNode.buildListNodesFromList(new int[] { 1, 2, 4 });
        DeleteMiddleNode.ListNode result = del.deleteMiddle(testCase);
        compare(expected, result);
    }

    @Test
    public void case2() {
        DeleteMiddleNode.ListNode testCase = DeleteMiddleNode.buildListNodesFromList(new int[] { 2, 1 });
        DeleteMiddleNode.ListNode expected = DeleteMiddleNode.buildListNodesFromList(new int[] { 2 });
        DeleteMiddleNode.ListNode result = del.deleteMiddle(testCase);
        compare(expected, result);
    }

}