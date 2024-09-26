/**
 * BST class
 *
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 9/24/2024
 * @param <T>
 *            declares which values the BSTNode key will hold
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private BSTNode<T> root;

    /**
     * Constructor for BinarySearchTree
     */
    public BinarySearchTree() {
        root = null;
    }


    /**
     * method to insert a val into the BST
     * 
     * @param val
     */
    public void insert(Record<T> record) {
        root = helpInsert(root, record);
    }


    /**
     * recursive method looking for spot to insert val
     * insert method allows for duplicates in the left subtree
     * 
     * @param cur
     *            root of subtree
     * @param val
     *            val to be inserted
     * @return BSTNode<T>
     */
    private BSTNode<T> helpInsert(BSTNode<T> cur, Record<T> record) {
        if (cur == null) {
            cur = new BSTNode<T>(record);
            return cur;
        }

        // check the children
        if (record.getKey().compareTo(cur.getRecord().getKey()) > 0) {
            root.setRight(helpInsert(root.getRight(), record)); // try
                                                                // rightSubTree
        }
        else { // this allows duplicates to the left subtree
            root.setLeft(helpInsert(root.getLeft(), record)); // try left
                                                              // subTree
        }

        // return unchanged root node
        return cur;
    }


    /**
     * delete val from BST
     * 
     * @param val
     *            key in record to be deleted
     * @return the BSTNode<T> if removed, null if not
     */
    public BSTNode<T> delete(Record<T> record) {
        BSTNode<T> temp = helpFind(root, record);
        if (temp != null) {
            root = helpDelete(root, record);
        }
        return temp;
    }


    /**
     * recursive method for remove val from subtree
     * 
     * @param cur
     *            root of current subtreee
     * @param val
     *            val to be removed
     * @return BSTNode<T>
     */
    private BSTNode<T> helpDelete(BSTNode<T> cur, Record<T> record) {
        // base case
        if (cur == null) {
            return cur;
        }

        // search for node
        int compare = record.getKey().compareTo(cur.getRecord().getKey());
        if (compare < 0) {
            cur.setLeft(helpDelete(cur.getLeft(), record));
        }
        else if (compare > 0) {
            cur.setRight(helpDelete(cur.getRight(), record));
        }
        else if (cur.getRecord().getSem().toString().equals(record.getSem()
            .toString())) {
            // check if the seminar's are equal
            // node to be deleted is found!

            // leaf node
            if (cur.getLeft() == null) {
                return cur.getRight();
            }
            else if (cur.getRight() == null) { // has only right child
                return cur.getLeft();
            }
            else {
                // cur has two children
                // cur should equal largest val in left subtree
                BSTNode<T> temp = getMax(cur.getLeft());
                cur.setData(temp.getRecord());
                cur.setLeft(deleteMax(cur.getLeft()));
            }
        }
        return cur;
    }


    /**
     * method to grab the node with the largest data in a subtree
     * 
     * @param node
     *            root of subtree
     * @return the node with the largest data
     */
    public BSTNode<T> getMax(BSTNode<T> node) {
        BSTNode<T> temp = node;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp;
    }


    /**
     * we know a max value will not have my right children
     * this method just sets the parent of the right nodes right child to the
     * max's left children
     * 
     * @param node
     *            root of subtree
     * @return root of subtree
     */
    public BSTNode<T> deleteMax(BSTNode<T> node) {
        if (node.getRight() == null) {
            return node.getLeft();
        }
        node.setRight(deleteMax(node.getRight()));
        return node;
    }


    /**
     * method to find a val in a BST
     * 
     * @param val
     *            the val being searched for
     * @return null if not found, otherwise the node is returned
     */
    public BSTNode<T> find(Record<T> record) {
        return helpFind(root, record);
    }


    /**
     * recursive method for find
     * 
     * @param cur
     *            the current root of the subtree we are at
     * @param val
     *            the value we are searching for
     * @return the BSTNode if found, null if not
     */
    private BSTNode<T> helpFind(BSTNode<T> cur, Record<T> record) {
        // we at end of tree
        if (cur == null) {
            return null;
        }

        // we found the BSTNode, the keys are the same, check seminars?
        if (record.getKey().compareTo(cur.getRecord().getKey()) == 0) {
            return cur;
        }
        else if (record.getKey().compareTo(cur.getRecord().getKey()) < 0) {
            return helpFind(cur.getLeft(), record);
        }
        else {
            return helpFind(cur.getRight(), record);
        }
    }

    // print

}
