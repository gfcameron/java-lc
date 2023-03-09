package deletemiddlenode;

class DeleteMiddleNode {

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

    public ListNode deleteMiddle(ListNode head) {
        // Corner case
        if (head.next == null) {
            return null;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode prevNode = null;
        while (fastNode != null && fastNode.next != null) {
            prevNode = slowNode;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        prevNode.next = prevNode.next.next;
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
                buildListNodesFromList(new int[] { 1, 3, 4, 7, 1, 2, 6 }),
                buildListNodesFromList(new int[] { 1, 2, 3, 4 }),
                buildListNodesFromList(new int[] { 2, 1 }),
        };

        DeleteMiddleNode del = new DeleteMiddleNode();
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: ", i);
            ListNode result = del.deleteMiddle(testCases[i]);
            for (ListNode node = result; node != null; node = node.next) {
                System.out.printf("%d ", node.val);
            }
            System.out.println();
        }
    }
}