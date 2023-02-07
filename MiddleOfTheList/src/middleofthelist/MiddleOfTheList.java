package middleofthelist;

class MiddleOfTheList {

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

    // middleNode: Find the middle of the list
    public ListNode middleNode(ListNode head) {
        ListNode middleList = head;
        int count = 0;
        for (ListNode node = head; node != null; node = node.next) {
            count++;
            // This step finds the midpoint
            if (count%2 == 0) {
                middleList = middleList.next;
            }
        }
        return middleList;
    }

    // main
    public static void main(String[] args) {
        // Construct from the tail
        ListNode case0 = new ListNode(5);
        case0 = new ListNode(4, case0);
        case0 = new ListNode(3, case0);
        case0 = new ListNode(2, case0);
        case0 = new ListNode(1, case0);

        ListNode case1 = new ListNode(6);
        case1 = new ListNode(5, case1);
        case1 = new ListNode(4, case1);
        case1 = new ListNode(3, case1);
        case1 = new ListNode(2, case1);
        case1 = new ListNode(1, case1);

        ListNode[] testCases = {
            case0,
            case1
        };

        MiddleOfTheList mid = new MiddleOfTheList();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: ", i);
            ListNode result = mid.middleNode(testCases[i]);
            for (ListNode node = result; node != null; node = node.next) {
                System.out.printf("%d ", node.val);
            }
            System.out.println();
        }
    }
}