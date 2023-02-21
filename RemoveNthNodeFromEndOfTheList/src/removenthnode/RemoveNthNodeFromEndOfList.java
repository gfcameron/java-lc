package removenthnode;

import java.util.ArrayList;
import java.util.List;

class RemoveNthNodeFromEndOfList {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node;
        for (node = head; node != null; node = node.next) {
            list.add(node);
        }
        // Do nothing if n > list size
        if (n > list.size()) {
            return head;
        }
        if (list.size() == 1) {
            if ((n == 1)) {
                return null;
            } else {
                // Do nothing if invalid n
                return head;
            }
        }
        if (list.size() == n) {
            return head.next;
        }
        ListNode prev = list.get(list.size()-n-1);
        prev.next = prev.next.next;
        return head;
    }

    // main
    public static void main(String[] args) {

        class TestCase {
            ListNode list;
            int nodeToRemove;

            TestCase(int nodeToRemove) {
                this.nodeToRemove = nodeToRemove;
            }

            void addAtHead(int num) {
                ListNode node = new ListNode(num);
                if (list == null) {
                    list = node;
                } else {
                    node.next = list;
                    list = node;
                }
            } 
        }
        TestCase case0 = new TestCase(2);
        case0.addAtHead(5);
        case0.addAtHead(4);
        case0.addAtHead(3);
        case0.addAtHead(2);
        case0.addAtHead(1);

        TestCase case1 = new TestCase(1);
        case1.addAtHead(1);

        TestCase case2 = new TestCase(1);
        case2.addAtHead(2);
        case2.addAtHead(1);

        TestCase[] testCases = {
            case0,
            case1,
            case2
        };


        RemoveNthNodeFromEndOfList mid = new RemoveNthNodeFromEndOfList();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: ", i);
            ListNode result = mid.removeNthFromEnd(testCases[i].list, testCases[i].nodeToRemove);
            for (ListNode node = result; node != null; node = node.next) {
                System.out.printf("%d ", node.val);
            }
            System.out.println();
        }
    }
}