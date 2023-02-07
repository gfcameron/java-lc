package reorder;

class ReorderList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val)
        { 
            this.val = val;
        }

        ListNode(int val, ListNode next)
        { 
            this.val = val;
            this.next = next;
        }
    }


    // Split, then reverse every second element
    // reverseList reverses the list
    private ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        return prevNode;
    }

        // middleNode: Find the middle of the list
    private ListNode splitListInTheMiddle(ListNode head) {
        ListNode middleList = head;
        ListNode firstTail = head;
        int count = 0;
        for (ListNode node = head; node != null; node = node.next) {
            count++;
            // This step finds the midpoint
            if (count%2 == 0) {
                firstTail = middleList;
                middleList = middleList.next;
            }
        }
        firstTail.next = null;
        return middleList;
    }

    public void reorderList(ListNode head) {
        // Deal with corner cases
        if (head == null || head.next == null) {
            return;
        }
        ListNode secondList = splitListInTheMiddle(head);
        secondList = reverseList(secondList);
        // Now, stitch them together
        ListNode curNode = head;
        do {
            // Stitch element of other list in
            ListNode secondNode = secondList;
            secondList = secondList.next;
            // For odd list lengths, we meed two elements from the 2nd list
            if (curNode.next != null) {
                secondNode.next = curNode.next;
            }
            curNode.next = secondNode;
            // Advance the lists and continue
            curNode = secondNode.next;
        } while (curNode != null && curNode != secondList);
    }

    public static void main(String[] args) {

        // Construct from the tail
        ListNode case0 = new ListNode(4);
        case0 = new ListNode(3, case0);
        case0 = new ListNode(2, case0);
        case0 = new ListNode(1, case0);

        ListNode case1 = new ListNode(5);
        case1 = new ListNode(4, case1);
        case1 = new ListNode(3, case1);
        case1 = new ListNode(2, case1);
        case1 = new ListNode(1, case1);

        ListNode case2 = new ListNode(1);

        ListNode[] testCases = {
            case0,
            case1,
            case2
        };

        ReorderList rl = new ReorderList();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: ", i);
            ListNode head = testCases[i];
            rl.reorderList(head);
            for (ListNode node = head; node != null; node = node.next) {
                System.out.printf("%d ", node.val);
            }
            System.out.println();
        }
    }
}