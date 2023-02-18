package mergetwobinarytrees;

import java.util.ArrayDeque;
import java.util.Queue;

class MergeTwoBinaryTrees {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val)
        { 
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right)
        { 
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // End case check
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // Both trees are not null
        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * @param elements
     * @return tree
     */
    public TreeNode BuildTree(int[] elements) {
        TreeNode root = new TreeNode();
        if (elements.length > 0) {
            int first = elements[0];
            if (first == Integer.MIN_VALUE) {
                return root;
            }
            root.val = first;
            if (elements.length > 1) {
                int idx = 1;
                Queue<TreeNode> stack = new ArrayDeque<>();
                stack.add(root);
                while (true) {
                    TreeNode cur = stack.remove();
                    if (cur.left == null) {
                        int elem = elements[idx++];
                        // Check null marker
                        if (elem != Integer.MIN_VALUE) {
                            cur.left = new TreeNode(elem);
                        }
                        if (idx == elements.length) {
                            break;
                        }
                    }
                    if (cur.left != null) {
                        stack.add(cur.left);
                    }
                    if (cur.right == null) {
                        int elem = elements[idx++];
                        // Check null marker
                        if (elem != Integer.MIN_VALUE) {
                            cur.right = new TreeNode(elem);
                        }
                        if (idx == elements.length) {
                            break;
                        }
                    }
                    if (cur.right != null) {
                        stack.add(cur.right);
                    }
                }
            }
        }
        return root;
    }

    /**
     * @param root
     * @return
     */
    public void PrintTree(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> stack = new ArrayDeque<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.remove();
                System.out.print(cur.val+" ");
                if (cur.left != null) {
                    stack.add(cur.left);
                }
                if (cur.right != null) {
                    stack.add(cur.right);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Use Integer.MIN_VALUE as null marker
        int[][][] testCases = new int[][][]{
            {
                {1,3,2,5},
                {2,1,3,Integer.MIN_VALUE, 4, Integer.MIN_VALUE, 7}
            },
            {
                {1},
                {1,2}
            }
        };
        MergeTwoBinaryTrees mt = new MergeTwoBinaryTrees();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: ", i);
            TreeNode first = mt.BuildTree(testCases[i][0]);
            TreeNode second = mt.BuildTree(testCases[i][1]);
            TreeNode result = mt.mergeTrees(first, second);
            mt.PrintTree(result);
        }
    }
}