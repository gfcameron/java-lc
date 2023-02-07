package mergetwobinarytrees;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class MergeTwoBinaryTreesTest {

    private static MergeTwoBinaryTrees mt;

    @BeforeClass
    public static void setUp() throws Exception {
        mt = new MergeTwoBinaryTrees();
    }

    private boolean compareTrees(MergeTwoBinaryTrees.TreeNode first, MergeTwoBinaryTrees.TreeNode second) {
        if ((first == null) && (second == null)) {
            return true;
        }
        // Only one is null
        if ((first == null) || (second == null)) {
            return false;
        }
        if (first.val != second.val) {
            return false;
        }
        return (compareTrees(first.left, second.left) && compareTrees(first.right, second.right));
    }


    @Test
    public void case0() {
        int[][] testCase = new int[][]{
            {1,3,2,5},
            {2,1,3,Integer.MIN_VALUE, 4, Integer.MIN_VALUE, 7}
        };

        int[] expectedCase = new int[]{3,4,5,5,4,Integer.MIN_VALUE,7};

        MergeTwoBinaryTrees.TreeNode first = mt.BuildTree(testCase[0]);
        MergeTwoBinaryTrees.TreeNode second = mt.BuildTree(testCase[1]);
    
        MergeTwoBinaryTrees.TreeNode expected = mt.BuildTree(expectedCase);

        MergeTwoBinaryTrees.TreeNode result = mt.mergeTrees(first, second);

        Assert.assertTrue(compareTrees(expected, result));
    }

    @Test
    public void case1() {
        int[][] testCase = new int[][]{
            {1},
            {1,2}
        };

        int[] expectedCase = new int[]{1,2};

        MergeTwoBinaryTrees.TreeNode first = mt.BuildTree(testCase[0]);
        MergeTwoBinaryTrees.TreeNode second = mt.BuildTree(testCase[1]);
    
        MergeTwoBinaryTrees.TreeNode expected = mt.BuildTree(expectedCase);

        MergeTwoBinaryTrees.TreeNode result = mt.mergeTrees(first, second);

        Assert.assertTrue(compareTrees(expected, result));
    }

}