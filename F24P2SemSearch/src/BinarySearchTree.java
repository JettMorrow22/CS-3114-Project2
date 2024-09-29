import java.io.PrintWriter;

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
    private int numberOfNodes;

    /**
     * Constructor for BinarySearchTree
     */
    public BinarySearchTree() {
        root = null;
        numberOfNodes = 0;
    }


    /**
     * method to insert a val into the BST
     * 
     * @param record
     *            record to be inserted
     */
    public void insert(Record<T> record) {
        root = helpInsert(root, record);
        numberOfNodes++;
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
            cur.setRight(helpInsert(cur.getRight(), record)); // try
                                                              // rightSubTree
        }
        else { // this allows duplicates to the left subtree
            cur.setLeft(helpInsert(cur.getLeft(), record)); // try left
                                                            // subTree
        }

        // return unchanged root node
        return cur;
    }


    /**
     * delete val from BST based of record
     * 
     * @param record
     *            record to be deleted
     * @return the BSTNode<T> if removed, null if not
     */
    public BSTNode<T> delete(Record<T> record) {
        BSTNode<T> temp = helpFind(root, record);
        if (temp != null) {
            root = helpDelete(root, record);
            numberOfNodes--;
        }
        return temp;
    }


    /**
     * recursive method for remove val from subtree, checks seminar in record,
     * if seminar is not equal then it checks left subtree for duplicate key
     * values
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
        else if (cur.getRecord().getSem().id() != record.getSem().id()) {
            // seminar isnt equal so check left subtree where duplicates are
            cur.setLeft(helpDelete(cur.getLeft(), record));
        }
        else {
            // key value is the same, check if seminar is the same

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
                cur.setRecord(temp.getRecord());
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
     * method to return BSTNode just based off its key value in record
     * 
     * @param key
     *            key value in record
     * @return BSTNode that has key, or null if not found
     */
    public BSTNode<T> findFromKey(T key) {
        return helpFindKey(root, key);
    }


    /**
     * recursive funtion to find BSTNode based off a key
     * 
     * @param cur
     *            node we are lookign at
     * @param key
     *            key
     * @return BSTNode if found, null if not
     */
    private BSTNode<T> helpFindKey(BSTNode<T> cur, T key) {
        if (cur == null) {
            return null;
        }

        // search for node
        int compare = key.compareTo(cur.getRecord().getKey());
        if (compare < 0) {
            return helpFindKey(cur.getLeft(), key);
        }
        else if (compare > 0) {
            return helpFindKey(cur.getRight(), key);
        }
        else {
            return cur;
        }
    }


    /**
     * method to find a val in a BST
     * 
     * @param record
     *            record being searched for
     * @return null if not found, otherwise the node is returned
     */
    public BSTNode<T> find(Record<T> record) {
        return helpFind(root, record);
    }


    /**
     * recursive method for find, checks if seminars are equal if seminars are
     * not equal if searches left subtree for duplicates
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

        // search for node
        int compare = record.getKey().compareTo(cur.getRecord().getKey());
        if (compare < 0) {
            return helpFind(cur.getLeft(), record);
        }
        else if (compare > 0) {
            return helpFind(cur.getRight(), record);
        }
        else if (cur.getRecord().getSem().id() != record.getSem().id()) {
            // seminar isnt equal so check left subtree where duplicates are
            return helpFind(cur.getLeft(), record);
        }
        else {
            return cur;
        }
    }


    /**
     * public method for printing tree
     * 
     * @param output
     *            PrintWriter obj
     */
    public void printTree(PrintWriter output) {
        inOrder(output, root, 0, getHeight(root));
        if (numberOfNodes == 0) {
            output.println("This tree is empty");
        }
        else {
            output.println("Number of records: " + numberOfNodes);
        }
    }


    /**
     * recursive inorder transversal for BST
     * 
     * @param output
     *            printwriter object
     * @param cur
     *            the current node we are looking at
     * @param level
     *            the level the cur node is at in the tree
     * @param height
     *            The height of teh BST
     */
    private void inOrder(
        PrintWriter output,
        BSTNode<T> cur,
        int level,
        int height) {
        if (cur == null) {
            level--;
            return;
        }

        inOrder(output, cur.getLeft(), level + 1, height);
        printNode(output, cur, level, height);
        inOrder(output, cur.getRight(), level + 1, height);
    }


    /**
     * method to print to PrintWriter
     * 
     * @param output
     *            PrintWriter object
     * @param cur
     *            the node we are printing
     * @param level
     *            the level of the tree we are at
     * @param height
     *            The height of teh BST
     */
    private void printNode(
        PrintWriter output,
        BSTNode<T> cur,
        int level,
        int height) {
        // print left node
        if (cur.getLeft() == null) {
            output.println(" ".repeat((height - level - 1) * 4) + "(null)");
        }

        // print left stem
        output.println(" ".repeat((height - level) * 4) + "\\");

        // print node
        output.println(" ".repeat((height - level) * 4) + "(" + cur.getRecord()
            .getKey() + ")");

        // print right stem
        output.println(" ".repeat((height - level) * 4) + "/");

        // print right node
        if (cur.getRight() == null) {
            output.println(" ".repeat((height - level - 1) * 4) + "(null)");
        }
    }


    /**
     * method to determine the number of BSTNodes within the range low to high
     * also prints the nodes and returns number of nodes in the range
     * 
     * @param cur
     *            current BSTNode we are looking at
     * @param low
     *            low of range
     * @param high
     *            high of range
     * @param output
     *            PrintWriter obj
     * @return the number of BSTNode in the range
     */
    public int range(BSTNode<T> cur, T low, T high, PrintWriter output) {

        if (cur == null) {
            return 1;
        }

        // either within the range, below it, or above
        int res = 0;
        T val = cur.getRecord().getKey();
        if (val.compareTo(low) < 0) { // less than low
            res += range(cur.getLeft(), low, high, output);
        }
        else if (val.compareTo(high) > 0) { // greater than right
            res += range(cur.getRight(), low, high, output);
        }
        else { // in the range
               // just to string the seminar
            output.println(cur.getRecord().getSem().toString());
            // this node good so check left and right
            res += 1 + range(cur.getLeft(), low, high, output) + range(cur
                .getRight(), low, high, output);
        }
        return res;
    }


    /**
     * method to determine the max height of the tree
     * 
     * @param cur
     *            current root of subtree
     * @return the height of the tree
     */
    public int getHeight(BSTNode<T> cur) {
        if (cur == null) {
            return 0;
        }

        int left = 1 + getHeight(cur.getLeft());
        int right = 1 + getHeight(cur.getRight());

        return Math.max(left, right);
    }


    /**
     * basic getter for root
     * 
     * @return the root Node
     */
    public BSTNode<T> getRoot() {
        return root;
    }


    /**
     * return numberOfNodes field
     * 
     * @return numberOfNOdes
     */
    public int getNumberOfNodes() {
        return numberOfNodes;
    }

}
