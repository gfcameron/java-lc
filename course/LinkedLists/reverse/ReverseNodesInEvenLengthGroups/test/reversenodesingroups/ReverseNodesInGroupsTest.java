package reversenodesingroups;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReverseNodesInGroupsTest {

    private static ReverseNodesInGroups rnig;

    @BeforeClass
    public static void setUp() throws Exception {
        rnig = new ReverseNodesInGroups();
    }

    private void compare(ReverseNodesInGroups.ListNode result, ReverseNodesInGroups.ListNode expected) {
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
        ReverseNodesInGroups.ListNode testCase = ReverseNodesInGroups
                .buildListNodesFromList(new int[] { 5, 2, 6, 3, 9, 1, 7, 3, 8, 4 });
        ReverseNodesInGroups.ListNode expected = ReverseNodesInGroups
                .buildListNodesFromList(new int[] { 5, 6, 2, 3, 9, 1, 4, 8, 3, 7 });
        ReverseNodesInGroups.ListNode result = rnig.reverseEvenLengthGroups(testCase);
        compare(expected, result);
    }

    @Test
    public void case1() {
        ReverseNodesInGroups.ListNode testCase = ReverseNodesInGroups
                .buildListNodesFromList(new int[] { 1, 1, 0, 6 });
        ReverseNodesInGroups.ListNode expected = ReverseNodesInGroups
                .buildListNodesFromList(new int[] { 1, 0, 1, 6 });
        ReverseNodesInGroups.ListNode result = rnig.reverseEvenLengthGroups(testCase);
        compare(expected, result);
    }

    @Test
    public void case2() {
        ReverseNodesInGroups.ListNode testCase = ReverseNodesInGroups
                .buildListNodesFromList(new int[] { 1, 1, 0, 6, 5 });
        ReverseNodesInGroups.ListNode expected = ReverseNodesInGroups
                .buildListNodesFromList(new int[] { 1, 0, 1, 5, 6 });
        ReverseNodesInGroups.ListNode result = rnig.reverseEvenLengthGroups(testCase);
        compare(expected, result);
    }
}