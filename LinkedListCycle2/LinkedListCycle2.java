import java.util.HashSet;
import java.util.Set;

class LinkedListCycle2 {

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


    // detectCycle: Check if the linked list is a LinkedListCycle
    public ListNode detectCycle(ListNode head) {
        ListNode curNode = head;
  
        Set<ListNode>nodes = new HashSet<ListNode>();

        do {
            if (!nodes.add(curNode)) {
                break;
            }
            curNode = curNode.next;
        } while (curNode != null);
        return curNode;
    }

    // main
    public static void main(String[] args) {
        // Construct from the tail
        ListNode case0 = new ListNode(-4);
        ListNode cycleHead = case0;
        case0 = new ListNode(0, case0);
        case0 = new ListNode(2, case0);
        ListNode cycleTail = case0;
        case0 = new ListNode(3, case0);
        cycleHead.next = cycleTail;


        ListNode case1 = new ListNode(2);
        cycleHead = case1;
        case1 = new ListNode(1, case1);
        cycleTail = case1;
        cycleHead.next = cycleTail;

        ListNode case2 = new ListNode();

        ListNode[] testCases = {
            case0,
            case1,
            case2
        };

        LinkedListCycle2 llc = new LinkedListCycle2();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d:", i);
            ListNode result = llc.detectCycle(testCases[i]);
            if (result == null) {
                System.out.println("no cycle");
            } else {
                int idx = 0;
                for (ListNode node = testCases[i]; node != result; node = node.next) {
                    idx++;
                }
                System.out.printf("cycle at node %d\n", idx);
            }
        }
    }
}