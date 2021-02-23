package sorters;

import collections.btree.ITree;
import collections.btree.impl.BSTree;
import utils.Constants;

public class TreeSorter {
    private final ITree myTree;

    public TreeSorter() {
        myTree = new BSTree();
    }

    public int[] treeSort(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException(Constants.ARRAY_IS_EMPTY_OR_NULL);
        }
        myTree.init(array);
        return myTree.toArray();
    }
}
