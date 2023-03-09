package oddevenlinkedlist;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class OddEvenLinkedListTest {

    private static OddEvenLinkedList oell;

    @BeforeClass
    public static void setUp() throws Exception {
        oell = new OddEvenLinkedList();
    }

    private void compare(OddEvenLinkedList.ListNode result, OddEvenLinkedList.ListNode expected) {
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
        OddEvenLinkedList.ListNode testCase = OddEvenLinkedList
                .buildListNodesFromList(new int[] { 1, 2, 3, 4, 5 });
        OddEvenLinkedList.ListNode expected = OddEvenLinkedList
                .buildListNodesFromList(new int[] { 1, 3, 5, 2, 4 });
        OddEvenLinkedList.ListNode result = oell.oddEvenList(testCase);
        compare(expected, result);
    }

    @Test
    public void case1() {
        OddEvenLinkedList.ListNode testCase = OddEvenLinkedList
                .buildListNodesFromList(new int[] { 2, 1, 3, 5, 6, 4, 7 });
        OddEvenLinkedList.ListNode expected = OddEvenLinkedList
                .buildListNodesFromList(new int[] { 2, 3, 6, 7, 1, 5, 4 });
        OddEvenLinkedList.ListNode result = oell.oddEvenList(testCase);
        compare(expected, result);
    }

    @Test
    public void case2() {
        OddEvenLinkedList.ListNode testCase = OddEvenLinkedList
                .buildListNodesFromList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
        OddEvenLinkedList.ListNode expected = OddEvenLinkedList
                .buildListNodesFromList(new int[] { 1, 3, 5, 7, 2, 4, 6, 8 });
        OddEvenLinkedList.ListNode result = oell.oddEvenList(testCase);
        compare(expected, result);
    }

}