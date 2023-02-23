package popnextright;

import java.util.ArrayDeque;
import java.util.Queue;

/*
Populate each next pointer to point to its next right node. If there is no next right node,
the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

*/



class PopulateNextRightPointers {

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {}

        Node(int val)
        { 
            this.val = val;
        }

        Node(int val, Node left, Node right)
        { 
            this.val = val;
            this.left = left;
            this.right = right;
        }
        Node(int val, Node left, Node right, Node next)
        { 
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public Node connect(Node root) {
        if (root != null) {
            Queue<Node> stack = new ArrayDeque<>();
            int nodes = 1;
            stack.add(root);
            Node cur = root;
            while (!stack.isEmpty()) {
                // Simple power of 2 check
                if ((cur != root) && ((nodes & -nodes) != nodes)) {
                    cur.next = stack.peek();
                }
                nodes++;
                cur = stack.remove();
                if (cur.left != null) {
                    stack.add(cur.left);
                }
                if (cur.right != null) {
                    stack.add(cur.right);
                }
            }
        }
        return root;
    }

    // BuildTree does a breadth first tree traversal
    public Node BuildTree(int[] elements) {
        Node root = null;
        if (elements.length > 0) {
            root = new Node(elements[0]);
            int idx = 1;
            Queue<Node> stack = new ArrayDeque<>();
            stack.add(root);
            while (true) {
                Node cur = stack.remove();
                if (cur.left == null) {
                    int elem = elements[idx++];
                    // Check null marker
                    if (elem != Integer.MIN_VALUE) {
                        cur.left = new Node(elem);
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
                        cur.right = new Node(elem);
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
        return root;
    }

    /**
     * @param root
     * @return
     */
    public void PrintTree(Node root) {
        Queue<Node> stack = new ArrayDeque<>();
        if (root != null) {
            stack.add(root);
            while (!stack.isEmpty()) {
                Node cur = stack.remove();
                System.out.print(cur.val+" ");
                if (cur.next == null) {
                    System.out.print("# ");
                }
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
        int[][] testCases = new int[][]{
            {1,2,3,4,5,6,7},
            {}
        };
        PopulateNextRightPointers pop = new PopulateNextRightPointers();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: ", i);
            Node first = pop.BuildTree(testCases[i]);
            Node result = pop.connect(first);
            pop.PrintTree(result);
        }
    }
}