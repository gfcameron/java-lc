package addtwonumbers;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class AddTwoNumbers {

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

    // Do the addition
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, node = null;
        int sum = 0, carry = 0;
        for (;;) {
            if (l1 == null && l2 == null) {
                if (carry == 0) {
                    break;
                }
                sum = 0;
            } else if (l1 == null) {
                sum = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (result == null) {
                result = new ListNode();
                node = result;
            } else {
                node.next = new ListNode();
                node = node.next;
            }
            sum += carry;
            node.val = sum % 10;
            carry = sum / 10;
        }
        return result;
    }

    // main
    public static void main(String[] args) {
        ListNode[][] testCases = {
                {
                        buildListNodesFromList(new int[] { 2, 4, 3 }),
                        buildListNodesFromList(new int[] { 5, 6, 4 }),
                },
                {
                        buildListNodesFromList(new int[] { 0 }),
                        buildListNodesFromList(new int[] { 0 }),
                },
                {
                        buildListNodesFromList(new int[] { 9, 9, 9, 9, 9, 9, 9 }),
                        buildListNodesFromList(new int[] { 9, 9, 9, 9 }),
                },
        };

        AddTwoNumbers a2n = new AddTwoNumbers();
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: ", i);
            ListNode result = a2n.addTwoNumbers(testCases[i][0], testCases[i][1]);
            for (ListNode node = result; node != null; node = node.next) {
                System.out.printf("%d ", node.val);
            }
            System.out.println();
        }
    }
}