package sortcollection;

import collections.llist.DoubleLList;

public class SortedDoubleList extends DoubleLList {
    public void sort() {
        if (root == null) {
            return;
        }
        Node current;
        Node index;
        int temp;
        for (current = root; current.next != null; current = current.next) {
            for (index = current.next; index != null; index = index.next) {
                if (current.value > index.value) {
                    temp = current.value;
                    current.value = index.value;
                    index.value = temp;
                }
            }
        }
    }
}
