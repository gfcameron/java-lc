package designlinkedlist;

import java.util.Arrays;

/*
Given the head of a singly linked list, group all the nodes with odd indices together
followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it
was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
*/

class DesignLinkedList {

    public static class MyLinkedList {

        private class ListNode {
            int val;
            ListNode prev;
            ListNode next;

            ListNode(int val, ListNode prev, ListNode next) {
                this.val = val;
                if (prev != null) {
                    prev.next = this;
                }
                this.prev = prev;
                if (next != null) {
                    next.prev = this;
                }
                this.next = next;
            }
        }

        ListNode root;

        public MyLinkedList() {
            this.root = null;
        }

        public int get(int index) {
            ListNode node = this.root;
            while (node != null && index-- > 0) {
                node = node.next;
            }
            return (node == null) ? -1 : node.val;
        }

        public void addAtHead(int val) {
            this.root = new ListNode(val, null, this.root);
        }

        public void addAtTail(int val) {
            // Find last node
            ListNode node = this.root;
            // Adding to empty list
            if (node == null) {
                this.root = new ListNode(val, null, null);
                return;
            }
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(val, node, null);
        }

        public void addAtIndex(int index, int val) {
            ListNode childNode = this.root;
            // Special case: first node
            if (index == 0) {
                addAtHead(val);
                return;
            }
            ListNode parentNode = null;
            while (childNode != null && --index >= 0) {
                parentNode = childNode;
                childNode = childNode.next;
            }
            // Error condition
            if (index > 0) {
                return;
            }
            // Index must be >= 1 so parent exists
            parentNode.next = new ListNode(val, parentNode, childNode);
        }

        public void deleteAtIndex(int index) {
            ListNode node = this.root;
            // Special case: first node
            if (index == 0) {
                if (this.root != null) {
                    this.root = this.root.next;
                }
                if (this.root != null) {
                    this.root.prev = null;
                }
                return;
            }
            while (node != null && --index >= 0) {
                node = node.next;
            }
            // Error condition
            if (index >= 0 || node == null) {
                return;
            }
            // Index must be >= 1 so parent exists
            ListNode parent = node.prev;
            parent.next = node.next;
            if (parent.next != null) {
                parent.next.prev = parent;
            }
        }

    }

    public static void main(String[] args) {

        TestCase[] testCases = {
                new TestCase(
                        new String[] { "MyLinkedList", "addAtTail", "get" },
                        new Integer[][] { {}, { 1 }, { 0 } }),
                new TestCase(
                        new String[] { "MyLinkedList", "addAtIndex", "addAtIndex", "addAtIndex", "get" },
                        new Integer[][] { {}, { 0, 10 }, { 0, 20 }, { 1, 30 }, { 0 } }),
                new TestCase(
                        new String[] { "MyLinkedList", "addAtHead", "addAtHead", "addAtHead", "addAtIndex",
                                "deleteAtIndex", "addAtHead", "addAtTail", "get", "addAtHead", "addAtIndex",
                                "addAtHead" },
                        new Integer[][] { {}, { 7 }, { 2 }, { 1 }, { 3, 0 }, { 2 }, { 6 }, { 4 }, { 4 }, { 4 },
                                { 5, 0 }, { 6 } }),
                new TestCase(
                        new String[] { "MyLinkedList", "addAtHead", "deleteAtIndex" },
                        new Integer[][] { {}, { 1 }, { 0 } }),
                new TestCase(
                        new String[] { "MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex",
                                "get" },
                        new Integer[][] { {}, { 1 }, { 3 }, { 1, 2 }, { 1 }, { 1 }, { 1 } }),
        };
        for (int i = 0; i < testCases.length; i++) {
            System.out.printf("Case %d: ", i);
            testCases[i].performActions();
            System.out.println(Arrays.toString(testCases[i].getResponse()));
        }
    }
}