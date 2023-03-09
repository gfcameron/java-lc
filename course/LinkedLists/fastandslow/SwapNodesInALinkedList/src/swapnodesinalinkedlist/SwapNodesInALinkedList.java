package swapnodesinalinkedlist;

import java.util.ArrayList;
import java.util.List;

/*
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning
and the kth node from the end (the list is 1-indexed).
 */

class SwapNodesInALinkedList {

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

    public ListNode swapNodes(ListNode head, int k) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        for (int i = 1; i < k; i++) {
            fastNode = fastNode.next;
        }
        ListNode swap = fastNode;
        while (fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        int val = swap.val;
        swap.val = slowNode.val;
        slowNode.val = val;
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
            int k;

            TestCase(ListNode list, int k) {
                this.list = list;
                this.k = k;
            }
        }

        TestCase[] testCases = {
                new TestCase(buildListNodesFromList(new int[] { 100, 90 }), 2),
                new TestCase(buildListNodesFromList(new int[] { 1, 2 }), 1),
                new TestCase(buildListNodesFromList(new int[] { 1, 2, 3, 4, 5 }), 2),
                new TestCase(buildListNodesFromList(new int[] { 7, 9, 6, 6, 7, 8, 3, 0, 9, 5 }), 5),
        };

        SwapNodesInALinkedList mid = new SwapNodesInALinkedList();
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: ", i);
            ListNode result = mid.swapNodes(testCases[i].list, testCases[i].k);
            for (ListNode node = result; node != null; node = node.next) {
                System.out.printf("%d ", node.val);
            }
            System.out.println();
        }
    }
}