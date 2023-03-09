package remlinkedlistelements;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RemLinkedListElementsTest {

    private static RemLinkedListElements rlle;

    @BeforeClass
    public static void setUp() throws Exception {
        rlle = new RemLinkedListElements();
    }

    private void compare(RemLinkedListElements.ListNode result, RemLinkedListElements.ListNode expected) {
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
        RemLinkedListElements.ListNode testCase = RemLinkedListElements
                .buildListNodesFromList(new int[] { 1, 2, 6, 3, 4, 5, 6 });
        RemLinkedListElements.ListNode expected = RemLinkedListElements
                .buildListNodesFromList(new int[] { 1, 2, 3, 4, 5 });
        RemLinkedListElements.ListNode result = rlle.removeElements(testCase, 6);
        compare(expected, result);
    }

    @Test
    public void case1() {
        RemLinkedListElements.ListNode testCase = RemLinkedListElements
                .buildListNodesFromList(new int[] {});
        RemLinkedListElements.ListNode expected = RemLinkedListElements
                .buildListNodesFromList(new int[] {});
        RemLinkedListElements.ListNode result = rlle.removeElements(testCase, 1);
        compare(expected, result);
    }

    @Test
    public void case2() {
        RemLinkedListElements.ListNode testCase = RemLinkedListElements
                .buildListNodesFromList(new int[] { 7, 7, 7, 7 });
        RemLinkedListElements.ListNode expected = RemLinkedListElements
                .buildListNodesFromList(new int[] {});
        RemLinkedListElements.ListNode result = rlle.removeElements(testCase, 7);
        compare(expected, result);
    }

}