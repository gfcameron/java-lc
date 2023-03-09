package maxtwinsumoflinkedlist;

/*
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is
known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2.
These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.
*/

class MaxTwinSumOfLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // reverseList reverses the list
    private ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return prevNode;
    }

    public int pairSum(ListNode head) {
        ListNode secondList = head;
        ListNode firstListEnd = head;
        int count = 0;
        for (ListNode nodePtr = head; nodePtr != null; nodePtr = nodePtr.next) {
            count++;
            // This step finds the midpoint
            if (count % 2 == 0) {
                firstListEnd = secondList;
                secondList = secondList.next;
            }
        }
        // If odd number of elements, ignore the first node of second list.
        if (count % 2 != 0) {
            secondList = secondList.next;
        }
        // Split the list down the middle, to create two lists
        firstListEnd.next = null;
        ListNode firstList = reverseList(head);
        // Generate a reversed first half
        ListNode revFirstList = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = revFirstList;
            revFirstList = curNode;
            curNode = nextNode;
        }
        int maxSum = Integer.MIN_VALUE;
        while (firstList != null) {
            maxSum = Math.max(maxSum, firstList.val + secondList.val);
            firstList = firstList.next;
            secondList = secondList.next;
        }
        return maxSum;
    }

    // This is a helper function to construct the listnode number representation
    public static ListNode buildListNodesFromList(int[] value) {
        ListNode root = null, node = null;
        for (int i = 0; i < value.length; i++) {
            if (root == null) {
                root = new ListNode();
                node = root;
            } else {
                node.next = new ListNode();
                node = node.next;
            }
            node.val = value[i];
        }
        return root;
    }

    public static void main(String[] args) {

        ListNode[] testCases = {
                buildListNodesFromList(new int[] { 5, 4, 2, 1 }),
                buildListNodesFromList(new int[] { 4, 2, 2, 3 }),
                buildListNodesFromList(new int[] { 1, 100000 }),
        };

        MaxTwinSumOfLinkedList mt = new MaxTwinSumOfLinkedList();
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: pair sum is %d\n", i, mt.pairSum(testCases[i]));
        }
    }
}