package remlinkedlistelements;

/*
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning
and the kth node from the end (the list is 1-indexed).
 */

class RemLinkedListElements {

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

    public ListNode removeElements(ListNode head, int val) {
        ListNode prevNode = null;
        ListNode curNode = head;
        for (curNode = head; curNode != null; curNode = curNode.next) {
            while (curNode.val == val) {
                if (curNode == head) {
                    // Advance head pointer
                    curNode = head.next;
                    head = curNode;
                } else {
                    // Skip this node
                    curNode = curNode.next;
                    prevNode.next = curNode;
                }
                if (curNode == null) {
                    return head;
                }
            }
            prevNode = curNode;
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

        class TestCase {
            ListNode list;
            int val;

            TestCase(ListNode list, int k) {
                this.list = list;
                this.val = k;
            }
        }

        TestCase[] testCases = {
                new TestCase(buildListNodesFromList(new int[] { 1, 2, 6, 3, 4, 5, 6 }), 6),
                new TestCase(buildListNodesFromList(new int[] {}), 1),
                new TestCase(buildListNodesFromList(new int[] { 7, 7, 7, 7 }), 7),
        };

        RemLinkedListElements rlle = new RemLinkedListElements();
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: ", i);
            ListNode result = rlle.removeElements(testCases[i].list, testCases[i].val);
            for (ListNode node = result; node != null; node = node.next) {
                System.out.printf("%d ", node.val);
            }
            System.out.println();
        }
    }
}