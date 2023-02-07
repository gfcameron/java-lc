class Palindrome {

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

    // isPalindrome: Check if the linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        ListNode secondList = head;
        ListNode firstListEnd = head;
        int count = 0;
        for (ListNode nodePtr = head; nodePtr != null; nodePtr = nodePtr.next) {
            count++;
            // This step finds the midpoint
            if (count%2 == 0) {
                firstListEnd = secondList;
                secondList = secondList.next;
            }
        }
        // If odd number of elements, ignore the first node of second list.
        if (count%2 != 0) {
            secondList = secondList.next;
        }
        // Split the list down the middle, to create two lists
        firstListEnd.next = null;
        ListNode firstList = reverseList(head);

        // Now compare the two lists
        while (firstList != null && secondList != null) {
            if (firstList.val != secondList.val) {
                return false;
            }
            firstList = firstList.next;
            secondList = secondList.next;
        }
        return true;
    }

    // main
    public static void main(String[] args) {
        // Construct from the tail
        ListNode case0 = new ListNode(1);
        case0 = new ListNode(2, case0);
        case0 = new ListNode(2, case0);
        case0 = new ListNode(1, case0);


        ListNode case1 = new ListNode(2);
        case1 = new ListNode(1, case1);

        ListNode case2 = new ListNode(1);

        ListNode case3 = new ListNode();

        ListNode case4 = new ListNode(1);
        case4 = new ListNode(0, case4);
        case4 = new ListNode(1, case4);

        ListNode[] testCases = {
            case0,
            case1,
            case2,
            case3,
            case4
        };

        Palindrome pal = new Palindrome();
        for ( int i=0; i < testCases.length; i++ ) {
            System.out.printf("Case %d: %s\n", i, pal.isPalindrome(testCases[i]));
        }
    }
}