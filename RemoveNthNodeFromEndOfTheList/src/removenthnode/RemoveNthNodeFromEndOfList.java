package removenthnode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

class RemoveNthNodeFromEndOfList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastNode = head, slowNode = head;
        for (int count = n; count > 0 && fastNode != null; count--) {
            fastNode = fastNode.next;
        }
        if (fastNode == null) {
            return head.next;
        }
        // Slow node lags n+1 behind fast node
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return head;
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

    // main
    public static void main(String[] args) {

        class TestCase {
            ListNode list;
            int nodeToRemove;

            TestCase(int nodeToRemove, ListNode list) {
                this.nodeToRemove = nodeToRemove;
                this.list = list;
            }

        }

        TestCase[] testCases = {
                new TestCase(2, buildListNodesFromList(new int[] { 5, 4, 3, 2, 1 })),
                new TestCase(1, buildListNodesFromList(new int[] { 1 })),
                new TestCase(1, buildListNodesFromList(new int[] { 2, 1 })),
                new TestCase(2, buildListNodesFromList(new int[] { 2, 1 })),
        };

        RemoveNthNodeFromEndOfList mid = new RemoveNthNodeFromEndOfList();
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: ", i);
            ListNode result = mid.removeNthFromEnd(testCases[i].list, testCases[i].nodeToRemove);
            for (ListNode node = result; node != null; node = node.next) {
                System.out.printf("%d ", node.val);
            }
            System.out.println();
        }
    }
}