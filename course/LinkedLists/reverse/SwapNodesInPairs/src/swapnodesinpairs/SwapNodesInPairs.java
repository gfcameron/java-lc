package swapnodesinpairs;

/*
Given a linked list, swap every two adjacent nodes and
return its head. You must solve the problem without
modifying the values in the list's nodes
(i.e., only nodes themselves may be changed.)
*/

class SwapNodesInPairs {

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

    public ListNode swapPairs(ListNode head) {
        // Check edge case: linked list has 0 or 1 nodes, just return
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode prev = null;
        while (head != null && head.next != null) {
            if (prev != null) {
                prev.next = head.next;
            }
            prev = head;
            ListNode nextNode = head.next.next;
            head.next.next = head;
            head.next = nextNode;
            head = nextNode; // Move onto next pair
        }
        return newHead;
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
                buildListNodesFromList(new int[] { 1, 2, 3, 4 }),
                buildListNodesFromList(new int[] {}),
                buildListNodesFromList(new int[] { 1 }),
        };

        SwapNodesInPairs sp = new SwapNodesInPairs();
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: ", i);
            ListNode head = testCases[i];
            ListNode result = sp.swapPairs(head);
            for (ListNode node = result; node != null; node = node.next) {
                System.out.printf("%d ", node.val);
            }
            System.out.println();
        }
    }
}