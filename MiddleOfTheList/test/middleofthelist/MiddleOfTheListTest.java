package middleofthelist;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MiddleOfTheListTest {

    private static MiddleOfTheList ml;

    @BeforeClass
    public static void setUp() throws Exception {
        ml = new MiddleOfTheList();
    }

    @Test
    public void case0() {
        MiddleOfTheList.ListNode testCase = new MiddleOfTheList.ListNode(5);
        testCase = new MiddleOfTheList.ListNode(4, testCase);
        testCase = new MiddleOfTheList.ListNode(3, testCase);
        MiddleOfTheList.ListNode expectedMiddleNode = testCase;
        testCase = new MiddleOfTheList.ListNode(2, testCase);
        testCase = new MiddleOfTheList.ListNode(1, testCase);

        MiddleOfTheList.ListNode result = ml.middleNode(testCase);
        Assert.assertEquals(expectedMiddleNode, result);
    }

    @Test
    public void case1() {
        MiddleOfTheList.ListNode testCase = new MiddleOfTheList.ListNode(6);
        testCase = new MiddleOfTheList.ListNode(5, testCase);
        testCase = new MiddleOfTheList.ListNode(4, testCase);
        MiddleOfTheList.ListNode expectedMiddleNode = testCase;
        testCase = new MiddleOfTheList.ListNode(3, testCase);
        testCase = new MiddleOfTheList.ListNode(2, testCase);
        testCase = new MiddleOfTheList.ListNode(1, testCase);

        MiddleOfTheList.ListNode result = ml.middleNode(testCase);
        Assert.assertEquals(expectedMiddleNode, result);
    }

    @Test
    public void case2() {
        MiddleOfTheList.ListNode testCase = new MiddleOfTheList.ListNode(1);
        MiddleOfTheList.ListNode expectedMiddleNode = testCase;
        MiddleOfTheList.ListNode result = ml.middleNode(testCase);
        Assert.assertEquals(expectedMiddleNode, result);
    }
}