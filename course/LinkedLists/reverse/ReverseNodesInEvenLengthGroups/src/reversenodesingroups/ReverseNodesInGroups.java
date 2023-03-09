package reversenodesingroups;

/*
You are given the head of a linked list.

The nodes in the linked list are sequentially assigned to non-empty groups whose lengths
form the sequence of the natural numbers (1, 2, 3, 4, ...). The length of a group is the
number of nodes assigned to it. In other words,

    The 1st node is assigned to the first group.
    The 2nd and the 3rd nodes are assigned to the second group.
    The 4th, 5th, and 6th nodes are assigned to the third group, and so on.

Note that the length of the last group may be less than or equal to 1 + the length of the
second to last group.

Reverse the nodes in each group with an even length, and return the head of the modified
linked list.
*/

class ReverseNodesInGroups {

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

  private ListNode revPartialList(ListNode head, ListNode tailNext) {
    ListNode revHead = tailNext;
    while (head != tailNext) {
      ListNode nextNode = head.next;
      head.next = revHead;
      revHead = head;
      head = nextNode;
    }
    return revHead;
  }

  // This is quite a bit faster
  public ListNode reverseEvenLengthGroups(ListNode head) {
    if (head.next == null) {
      return head;
    }
    ListNode curGroupPrev = head;
    ListNode curGroupHead = head.next;
    ListNode curGroupTail = head.next;
    ListNode curGroupTailNext = curGroupTail.next;
    int curGroup = 2;
    int curGroupNodes = 1;

    while (curGroupTailNext != null) {
      curGroupTail = curGroupTailNext;
      curGroupTailNext = curGroupTailNext.next;
      curGroupNodes += 1;
      if (curGroupNodes == curGroup) {
        if (curGroup % 2 == 0) {
          revPartialList(curGroupHead, curGroupTailNext);
          curGroupPrev.next = curGroupTail;
          curGroupPrev = curGroupHead;
        } else {
          curGroupPrev = curGroupTail;
        }
        curGroupHead = curGroupTailNext;
        curGroupNodes = 0;
        curGroup += 1;
      }
    }
    if (curGroupNodes % 2 == 0) {
      ListNode revHead = revPartialList(curGroupHead, curGroupTailNext);
      curGroupPrev.next = revHead;
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

  public static void main(String[] args) {

    ListNode[] testCases = {
        buildListNodesFromList(new int[] { 1, 1, 0, 6, 5 }),
        buildListNodesFromList(new int[] { 5, 2, 6, 3, 9, 1, 7, 3, 8, 4 }),
        buildListNodesFromList(new int[] { 1, 1, 0, 6 }),
    };

    ReverseNodesInGroups rnig = new ReverseNodesInGroups();
    for (int i = 0; i < testCases.length; i++) {
      System.out.printf("Case %d: reverse nodes in even groups ", i);
      ListNode result = rnig.reverseEvenLengthGroups(testCases[i]);
      for (ListNode node = result; node != null; node = node.next) {
        System.out.printf("%d ", node.val);
      }
      System.out.println();
    }
  }
}