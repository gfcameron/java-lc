package removedupfromsortedlist;

/*
Given the head of a sorted linked list, delete all duplicates such that each element
appears only once. Return the linked list sorted as well.
 */

class RemoveDupFromSortedList {

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
        ListNode node = head;
        while (node != null) {
            int val = node.val;
            ListNode next = node.next;
            while (next != null && next.val == val) {
                next = next.next;
            }
            node.next = next;
            node = node.next;
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
                buildListNodesFromList(new int[] { 1, 1, 2 }),
                buildListNodesFromList(new int[] { 1, 1, 2, 3, 3 }),
        };

        RemoveDupFromSortedList mid = new RemoveDupFromSortedList();
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