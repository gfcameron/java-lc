package convbinarynuminalinkedlisttoint;

class ConvBinNumInALinkedListToInt {

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

    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode curNode = head;
        while (curNode != null) {
            result = (result << 1) | curNode.val;
            curNode = curNode.next;
        }
        return result;
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
                buildListNodesFromList(new int[] { 1, 0, 1 }),
                buildListNodesFromList(new int[] { 0 }),
        };
        ConvBinNumInALinkedListToInt conv = new ConvBinNumInALinkedListToInt();
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: %d\n", i, conv.getDecimalValue(testCases[i]));
        }
    }
}