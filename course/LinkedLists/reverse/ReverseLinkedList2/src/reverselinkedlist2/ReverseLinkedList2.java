package reverselinkedlist2;

/*
Given a linked list, swap every two adjacent nodes and
return its head. You must solve the problem without
modifying the values in the list's nodes
(i.e., only nodes themselves may be changed.)
*/

class ReverseLinkedList2 {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        int count;
        ListNode curNode = head;
        ListNode leftAnchor = null, rightAnchor = null;
        for (count = 1; count < left; count++) {
            leftAnchor = curNode;
            curNode = curNode.next;
            if (curNode == null) {
                return head;
            }
        }
        rightAnchor = curNode;
        ListNode prevNode = null;
        // Do the reversal here
        while (curNode != null && count <= right) {
            count++;
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        // Corner case
        if (leftAnchor == null) {
            head = prevNode;
        } else {
            leftAnchor.next = prevNode;
        }
        rightAnchor.next = curNode;
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

    public static void main(String[] args) {

        class TestCase {
            ListNode list;
            int left;
            int right;

            TestCase(ListNode list, int left, int right) {
                this.list = list;
                this.left = left;
                this.right = right;
            }
        }

        TestCase[] testCases = {
                new TestCase(buildListNodesFromList(new int[] { 1, 2, 3, 4, 5 }), 3, 4),
                new TestCase(buildListNodesFromList(new int[] { 1, 2, 3 }), 1, 2),
                new TestCase(buildListNodesFromList(new int[] { 3, 5 }), 1, 1),
                new TestCase(buildListNodesFromList(new int[] { 3, 5 }), 1, 2),
                new TestCase(buildListNodesFromList(new int[] { 1, 2, 3, 4, 5 }), 2, 4),
                new TestCase(buildListNodesFromList(new int[] { 5 }), 1, 1),
        };

        ReverseLinkedList2 rll2 = new ReverseLinkedList2();
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: reverse between %d and %d | ", i, testCases[i].left, testCases[i].right);
            ListNode result = rll2.reverseBetween(testCases[i].list, testCases[i].left, testCases[i].right);
            for (ListNode node = result; node != null; node = node.next) {
                System.out.printf("%d ", node.val);
            }
            System.out.println();
        }
    }
}