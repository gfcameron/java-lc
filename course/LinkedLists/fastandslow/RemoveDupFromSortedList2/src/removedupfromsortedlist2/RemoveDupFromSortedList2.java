package removedupfromsortedlist2;

/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list. Return the linked list sorted as well.
 */

class RemoveDupFromSortedList2 {

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        ListNode node = head;
        while (node != null) {
            int val = node.val;
            ListNode next = node.next;
            while (next != null && next.val == val) {
                next = next.next;
            }
            if (next == node.next) {
                // We didn't do anything, no dupes found
                prev = node;
            } else {
                prev.next = next;
                if (node == head) {
                    head = next;
                    prev = next;
                }
            }
            node = next;
        }
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

        ListNode[] testCases = {
                buildListNodesFromList(new int[] { 1, 2, 2 }),
                buildListNodesFromList(new int[] { 1, 2, 3, 3, 4, 4, 5 }),
                buildListNodesFromList(new int[] { 1, 1, 1, 2, 3 }),
        };

        RemoveDupFromSortedList2 mid = new RemoveDupFromSortedList2();
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: ", i);
            ListNode result = mid.deleteDuplicates(testCases[i]);
            for (ListNode node = result; node != null; node = node.next) {
                System.out.printf("%d ", node.val);
            }
            System.out.println();
        }
    }
}