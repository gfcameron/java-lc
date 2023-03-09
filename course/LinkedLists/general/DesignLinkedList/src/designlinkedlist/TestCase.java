package designlinkedlist;

/*
 * This is for LeetCode 707.  I would prefer to bundle actions as an enum with args as one class
 * but the test cases are written this way so....
 */
class TestCase {

    DesignLinkedList.MyLinkedList myLinkedList;

    String[] actions;
    Integer[][] args;
    Integer[] response;
    int curAction;

    TestCase(String[] actions, Integer[][] args) {
        this.actions = actions;
        this.args = args;
        response = new Integer[actions.length];
        curAction = 0;
    }

    // Get the response
    Integer[] getResponse() {
        return response;
    }

    void resetActions() {
        curAction = 0;
    }

    Integer performAction(String action, Integer[] args) {
        switch (action) {
            case "MyLinkedList":
                myLinkedList = new DesignLinkedList.MyLinkedList();
                return null;
            case "get":
                return myLinkedList.get(args[0]);
            case "addAtHead":
                myLinkedList.addAtHead(args[0]);
                return null;
            case "addAtTail":
                myLinkedList.addAtTail(args[0]);
                return null;
            case "addAtIndex":
                myLinkedList.addAtIndex(args[0], args[1]);
                return null;
            case "deleteAtIndex":
                myLinkedList.deleteAtIndex(args[0]);
                return null;
            default: // NOP - maybe throw exception here?
                return null;
        }
    }

    void performActions() {
        for (int i = 0; i < actions.length; i++) {
            response[i] = performAction(actions[i], args[i]);
        }
    }

}