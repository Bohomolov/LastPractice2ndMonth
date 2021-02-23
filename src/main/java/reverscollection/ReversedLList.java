package reverscollection;

import collections.llist.LList;

public class ReversedLList extends LList {

    public void reverse() {
        if (root == null){
            return;
        }
        root = reverseInternal(root);
    }

    private Node reverseInternal(Node le) {
        if (le == null) {
            return le;
        }
        if (le.next == null) {
            return le;
        }
        Node newHeadNode = reverseInternal(le.next);
        le.next.next = le;
        le.next = null;
        return newHeadNode;
    }
}
