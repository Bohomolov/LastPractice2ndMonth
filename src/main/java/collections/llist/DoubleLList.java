package collections.llist;


import collections.IList;

public class DoubleLList implements IList {
    protected Node root = null;
    protected Node tail = null;
    protected int size = 0;

    @Override
    public void init(int[] arr) {
        for (int i : arr) {
            add(i);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(int value) {
        Node newElement = new Node(null, value, null);
        size++;
        if (root == null) {
            root = newElement;
        } else {
            newElement.prev = tail;
            tail.next = newElement;
        }
        tail = newElement;
        return true;
    }

    @Override
    public int[] toArray() {
        if (root == null) {
            return new int[]{};
        }
        int[] array = new int[size];
        return toArray(root, 0, array);
    }

    private int[] toArray(Node element, int currentIndex, int[] array) {
        if (currentIndex == size - 1) {
            array[currentIndex] = element.value;
            return array;
        }
        array[currentIndex] = element.value;
        return toArray(element.next, currentIndex + 1, array);
    }

    protected static class Node {
        public int value;
        public Node next;
        public Node prev;

        protected Node(Node prev, int value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
