package addtwonumbers;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddTwoNumbersTest {

    private static AddTwoNumbers a2n;

    @BeforeClass
    public static void setUp() throws Exception {
        a2n = new AddTwoNumbers();
    }

    private void compare(AddTwoNumbers.ListNode result, AddTwoNumbers.ListNode expected) {
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
        AddTwoNumbers.ListNode[] testCase = {
                AddTwoNumbers.buildListNodesFromList(new int[] { 2, 4, 3 }),
                AddTwoNumbers.buildListNodesFromList(new int[] { 5, 6, 4 }),
                // Expected value
                AddTwoNumbers.buildListNodesFromList(new int[] { 7, 0, 8 }),
        };
        AddTwoNumbers.ListNode result = a2n.addTwoNumbers(testCase[0], testCase[1]);
        AddTwoNumbers.ListNode expected = testCase[2];
        compare(result, expected);
    }

    @Test
    public void case1() {
        AddTwoNumbers.ListNode[] testCase = {
                AddTwoNumbers.buildListNodesFromList(new int[] { 0 }),
                AddTwoNumbers.buildListNodesFromList(new int[] { 0 }),
                // Expected value
                AddTwoNumbers.buildListNodesFromList(new int[] { 0 }),
        };
        AddTwoNumbers.ListNode result = a2n.addTwoNumbers(testCase[0], testCase[1]);
        AddTwoNumbers.ListNode expected = testCase[2];
        compare(result, expected);
    }

    @Test
    public void case2() {
        AddTwoNumbers.ListNode[] testCase = {
                AddTwoNumbers.buildListNodesFromList(new int[] { 9, 9, 9, 9, 9, 9, 9 }),
                AddTwoNumbers.buildListNodesFromList(new int[] { 9, 9, 9, 9 }),
                // Expected value
                AddTwoNumbers.buildListNodesFromList(new int[] { 8, 9, 9, 9, 0, 0, 1 }),
        };
        AddTwoNumbers.ListNode result = a2n.addTwoNumbers(testCase[0], testCase[1]);
        AddTwoNumbers.ListNode expected = testCase[2];
        compare(result, expected);
    }
}