package removedupfromsortedlist;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RemoveDupFromSortedListTest {

    private static RemoveDupFromSortedList dd;

    @BeforeClass
    public static void setUp() throws Exception {
        dd = new RemoveDupFromSortedList();
    }

    private void compare(RemoveDupFromSortedList.ListNode result, RemoveDupFromSortedList.ListNode expected) {
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
        RemoveDupFromSortedList.ListNode testCase = RemoveDupFromSortedList
                .buildListNodesFromList(new int[] { 1, 1, 2 });
        RemoveDupFromSortedList.ListNode expected = RemoveDupFromSortedList
                .buildListNodesFromList(new int[] { 1, 2 });
        RemoveDupFromSortedList.ListNode result = dd.deleteDuplicates(testCase);
        compare(expected, result);
    }

    @Test
    public void case1() {
        RemoveDupFromSortedList.ListNode testCase = RemoveDupFromSortedList
                .buildListNodesFromList(new int[] { 1, 1, 2, 3, 3 });
        RemoveDupFromSortedList.ListNode expected = RemoveDupFromSortedList
                .buildListNodesFromList(new int[] { 1, 2, 3 });
        RemoveDupFromSortedList.ListNode result = dd.deleteDuplicates(testCase);
        compare(expected, result);
    }
}