package reorder;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReorderListTest {

    private static ReorderList fd;

    @BeforeClass
    public static void setUp() throws Exception {
        fd = new ReorderList();
    }

    @Test
    public void case0() {
        ReorderList.ListNode testCase0 = new ReorderList.ListNode(4);
        testCase0 = new ReorderList.ListNode(3, testCase0);
        testCase0 = new ReorderList.ListNode(2, testCase0);
        testCase0 = new ReorderList.ListNode(1, testCase0);

        fd.reorderList(testCase0);

        ReorderList.ListNode expectedCase0 = new ReorderList.ListNode(3);
        expectedCase0 = new ReorderList.ListNode(2, expectedCase0);
        expectedCase0 = new ReorderList.ListNode(4, expectedCase0);
        expectedCase0 = new ReorderList.ListNode(1, expectedCase0);

        // Check each element in the list
        for (ReorderList.ListNode node = testCase0; node != null; node = node.next) {
            Assert.assertEquals(testCase0, expectedCase0);
        }
    }

    @Test
    public void case1() {
        ReorderList.ListNode testCase1 = new ReorderList.ListNode(5);
        testCase1 = new ReorderList.ListNode(4, testCase1);
        testCase1 = new ReorderList.ListNode(3, testCase1);
        testCase1 = new ReorderList.ListNode(2, testCase1);
        testCase1 = new ReorderList.ListNode(1, testCase1);

        fd.reorderList(testCase1);

        ReorderList.ListNode expectedCase1 = new ReorderList.ListNode(3);
        expectedCase1 = new ReorderList.ListNode(4, expectedCase1);
        expectedCase1 = new ReorderList.ListNode(2, expectedCase1);
        expectedCase1 = new ReorderList.ListNode(5, expectedCase1);
        expectedCase1 = new ReorderList.ListNode(1, expectedCase1);

        // Check each element in the list
        for (ReorderList.ListNode node = testCase1; node != null; node = node.next) {
            Assert.assertEquals(testCase1, expectedCase1);
        }
    }

    @Test
    public void case2() {
        ReorderList.ListNode testCase2 = new ReorderList.ListNode(1);

        fd.reorderList(testCase2);

        ReorderList.ListNode expectedCase2 = new ReorderList.ListNode(1);
        Assert.assertEquals(testCase2, expectedCase2);
    }

}