package designlinkedlist;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DesignLinkedListTest {

    @BeforeClass
    public static void setUp() throws Exception {

    }

    @Test
    public void case0() {

        TestCase testCase = new TestCase(
                new String[] { "MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex",
                        "get" },
                new Integer[][] { {}, { 1 }, { 3 }, { 1, 2 }, { 1 }, { 1 }, { 1 } });
        testCase.performActions();

        Integer[] expected = { null, null, null, null, 2, null, 3 };
        Assert.assertArrayEquals(expected, testCase.getResponse());
    }

    @Test
    public void case1() {

        TestCase testCase = new TestCase(
                new String[] { "MyLinkedList", "addAtHead", "deleteAtIndex" },
                new Integer[][] { {}, { 1 }, { 0 } });
        testCase.performActions();

        Integer[] expected = { null, null, null };
        Assert.assertArrayEquals(expected, testCase.getResponse());
    }

    @Test
    public void case2() {

        TestCase testCase = new TestCase(
                new String[] { "MyLinkedList", "addAtHead", "addAtHead", "addAtHead", "addAtIndex",
                        "deleteAtIndex", "addAtHead", "addAtTail", "get", "addAtHead", "addAtIndex",
                        "addAtHead" },
                new Integer[][] { {}, { 7 }, { 2 }, { 1 }, { 3, 0 }, { 2 }, { 6 }, { 4 }, { 4 }, { 4 },
                        { 5, 0 }, { 6 } });
        testCase.performActions();

        Integer[] expected = { null, null, null, null, null, null, null, null, 4, null, null, null };
        Assert.assertArrayEquals(expected, testCase.getResponse());
    }

    @Test
    public void case3() {

        TestCase testCase = new TestCase(
                new String[] { "MyLinkedList", "addAtIndex", "addAtIndex", "addAtIndex", "get" },
                new Integer[][] { {}, { 0, 10 }, { 0, 20 }, { 1, 30 }, { 0 } });

        testCase.performActions();

        Integer[] expected = { null, null, null, null, 20 };
        Assert.assertArrayEquals(expected, testCase.getResponse());
    }

    @Test
    public void case4() {

        TestCase testCase = new TestCase(
                new String[] { "MyLinkedList", "addAtTail", "get" },
                new Integer[][] { {}, { 1 }, { 0 } });

        testCase.performActions();

        Integer[] expected = { null, null, 1 };
        Assert.assertArrayEquals(expected, testCase.getResponse());
    }

}