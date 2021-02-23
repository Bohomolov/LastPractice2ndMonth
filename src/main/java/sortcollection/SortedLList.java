package sortcollection;

import collections.llist.LList;

public class SortedLList extends LList {

    public void sort() {
        if (root == null) {
            return;
        }
        root = sortInternal(root);
    }

    private Node sortInternal(Node le) {
        if (le.next == null) {
            return le;
        }
        Node min = le;
        Node beforeMin = null;
        Node ptr;
        for (ptr = le; ptr.next != null; ptr = ptr.next) {
            if (ptr.next.value < min.value) {
                min = ptr.next;
                beforeMin = ptr;
            }
        }
        if (min != le) {
            le = swapNodes(le, min, beforeMin);
        }
        le.next = sortInternal(le.next);
        return le;
    }

    private Node swapNodes(Node currNode1, Node currNode2, Node prevNode2) {
        prevNode2.next = currNode1;
        Node temp = currNode2.next;
        currNode2.next = currNode1.next;
        currNode1.next = temp;
        return currNode2;
    }
}
