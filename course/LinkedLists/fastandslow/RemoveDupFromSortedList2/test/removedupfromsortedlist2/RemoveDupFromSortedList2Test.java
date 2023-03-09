package removedupfromsortedlist2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RemoveDupFromSortedList2Test {

    private static RemoveDupFromSortedList2 dd;

    @BeforeClass
    public static void setUp() throws Exception {
        dd = new RemoveDupFromSortedList2();
    }

    private void compare(RemoveDupFromSortedList2.ListNode result, RemoveDupFromSortedList2.ListNode expected) {
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
        RemoveDupFromSortedList2.ListNode testCase = RemoveDupFromSortedList2
                .buildListNodesFromList(new int[] { 1, 2, 3, 3, 4, 4, 5 });
        RemoveDupFromSortedList2.ListNode expected = RemoveDupFromSortedList2
                .buildListNodesFromList(new int[] { 1, 2, 5 });
        RemoveDupFromSortedList2.ListNode result = dd.deleteDuplicates(testCase);
        compare(expected, result);
    }

    @Test
    public void case1() {
        RemoveDupFromSortedList2.ListNode testCase = RemoveDupFromSortedList2
                .buildListNodesFromList(new int[] { 1, 1, 1, 2, 3 });
        RemoveDupFromSortedList2.ListNode expected = RemoveDupFromSortedList2
                .buildListNodesFromList(new int[] { 2, 3 });
        RemoveDupFromSortedList2.ListNode result = dd.deleteDuplicates(testCase);
        compare(expected, result);
    }

    @Test
    public void case2() {
        RemoveDupFromSortedList2.ListNode testCase = RemoveDupFromSortedList2
                .buildListNodesFromList(new int[] { 1, 2, 2 });
        RemoveDupFromSortedList2.ListNode expected = RemoveDupFromSortedList2
                .buildListNodesFromList(new int[] { 1 });
        RemoveDupFromSortedList2.ListNode result = dd.deleteDuplicates(testCase);
        compare(expected, result);
    }
}