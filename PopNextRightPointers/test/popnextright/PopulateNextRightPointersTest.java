package popnextright;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class PopulateNextRightPointersTest {

    private static PopulateNextRightPointers pop;

    @BeforeClass
    public static void setUp() throws Exception {
        pop = new PopulateNextRightPointers();
    }


    // Compare the tree against the expected value list
    private boolean checkTree(PopulateNextRightPointers.Node root, int[] expected) {
        // Check for null tree.  Was it expected?
        if (root == null) {
            return (expected.length == 0);
        }

        Queue<PopulateNextRightPointers.Node> stack = new ArrayDeque<>();
        stack.add(root);
        PopulateNextRightPointers.Node cur = null;
        int idx = 0;
        while (!stack.isEmpty()) {
            // More unexpected tree data
            if (idx == expected.length) {
                return false;
            }
            PopulateNextRightPointers.Node prev = cur;
            cur = stack.remove();
            if (prev != null) {
                if ((prev.next != null) && (prev.next != cur)) {
                    return false;
                }
            }
            if (cur.val != expected[idx++]) {
                return false;
            }
            // Shouldn't reach end of expected list with more tree data
            if (idx == expected.length) {
                return false;
            }
            if (expected[idx] == Integer.MIN_VALUE) {
                if (cur.next != null) {
                    return false;
                }
                idx++;  // Ok to be past the end if no more tree data.  Check next iteration.
            } else {
                if (cur.next == null) {
                    return false;
                }
                if (cur.next.val != expected[idx]) {
                    return false;
                }
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
            if (cur.right != null) {
                stack.add(cur.right);
            }
        }
        return (stack.isEmpty() && (idx == expected.length));
    }


    @Test
    public void case0() {
        int[] testCase = new int[]{1,2,3,4,5,6,7};

        PopulateNextRightPointers.Node tree = pop.BuildTree(testCase);
        PopulateNextRightPointers.Node result = pop.connect(tree);
        int[] expectedResult = new int[]{1,Integer.MIN_VALUE,2,3,Integer.MIN_VALUE,4,5,6,7,Integer.MIN_VALUE};
        Assert.assertTrue(checkTree(result, expectedResult));
    }

    @Test
    public void case1() {
        int[] testCase = new int[]{};

        PopulateNextRightPointers.Node tree = pop.BuildTree(testCase);
        PopulateNextRightPointers.Node result = pop.connect(tree);
        int[] expectedResult = new int[]{};
        Assert.assertTrue(checkTree(result, expectedResult));
    }

}