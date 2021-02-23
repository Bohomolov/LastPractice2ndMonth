package collections.llist;


import collections.IList;

public class LList implements IList {
    protected Node root = null;


    @Override
    public void init(int[] arr) {
        for (int i : arr) {
            add(i);
        }
    }

    @Override
    public int size() {
        return size(root, 0);
    }

    @Override
    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        } else {
            add(value, root);
        }
        return true;
    }

    private void add(int value, Node element) {
        if (element.next == null) {
            element.next = new Node(value);
            return;
        }
        add(value, element.next);
    }

    @Override
    public int[] toArray() {
        if (root == null) {
            return new int[]{};
        }
        int[] array = new int[size()];
        return toArray(root, 0, array);
    }

    private int[] toArray(Node element, int currentIndex, int[] array) {
        if (element.next == null) {
            array[currentIndex] = element.value;
            return array;
        }
        array[currentIndex] = element.value;
        return toArray(element.next, currentIndex + 1, array);
    }

    protected static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private int size(Node element, int size) {
        if (element == null) {
            return size;
        }
        return size(element.next, size + 1);
    }
}
