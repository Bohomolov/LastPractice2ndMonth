package reverscollection;

import collections.llist.DoubleLList;

public class ReversedDoubleList extends DoubleLList {

    public void reverse() {
        if (root == null){
            return;
        }

        Node temp = null;
        Node current = root;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            root = temp.prev;
        }
    }
}
