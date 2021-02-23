package collections.btree.impl;


import collections.IList;
import collections.btree.ITree;
import collections.llist.LList;

public class BSTree implements ITree {
    private Node root;

    public BSTree() {
        root = null;
    }

    @Override
    public void init(int[] array) {
        for (int i : array) {
            add(i);
        }
    }

    @Override
    public int[] toArray() {
        if (root == null) {
            return new int[]{};
        }
        IList myList = new LList();
        toArray(myList, root);
        return myList.toArray();
    }

    @Override
    public void add(int value) {
        if (root == null) {
            root = new Node(value, null, null);
        } else {
            add(value, root);
        }
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        private Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private void toArray(IList myList, Node node) {
        if (node != null) {
            toArray(myList, node.left);
            myList.add(node.value);
            toArray(myList, node.right);
        }
    }

    private void add(int value, Node node) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value, null, null);
            } else {
                add(value, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value, null, null);
            } else {
                add(value, node.right);
            }
        }
    }

}
