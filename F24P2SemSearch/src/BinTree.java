import java.io.PrintWriter;

/**
 * Bin Tree Class
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 10/14/2024
 */
public class BinTree {

    private BinTreeNode root;
    private int worldSize;

    /**
     * Constructor for BinTree has size of world
     * 
     * @param size
     *            worldSize
     */
    public BinTree(int size) {
        root = FlyweightNode.get();
        worldSize = size;
    }


    /**
     * Public method for insert
     * 
     * @param sem
     *            Seminar Obj
     */
    public void insert(Seminar sem) {
        root = helpInsert(sem);
    }


    /**
     * private recursive method for inserting with different binTreeNodess
     * 
     * @param sem
     *            Seminar obj
     * @return root BinTreeNode
     */
    private BinTreeNode helpInsert(Seminar sem) {
        return root.insert(sem, 0, 0, worldSize, worldSize);
    }


    /**
     * Public method to delete BinTreeNode from binTree
     * 
     * @param sem
     *            Seminar obj to be deleted
     */
    public void delete(Seminar sem) {
        root = helpDelete(sem);
    }


    /**
     * private recurisive method to remove binTreeNode from bin Tree
     * 
     * @param sem
     *            Seminar obj to be removed
     * @return new root of BinTree
     */
    private BinTreeNode helpDelete(Seminar sem) {
        return root.delete(sem, 0, 0, worldSize, worldSize);
    }


    /**
     * Method to print the BinTree
     * 
     * @param output
     *            PrintWriter obj
     */
    public void printTree(PrintWriter output) {
        output.println("Location Tree:");
        if (root == FlyweightNode.get()) {
            output.println("E");
            return;
        }
        reversePreOrder(root, 0, getHeight(root), output);

    }


    /**
     * Method to trasnvere bin tree in as right, root, left (Reverse Pre Order)
     * 
     * @param cur
     *            cur BinTreeNode
     * @param level
     *            level of the BinTreeNode
     * @param height
     *            height of the BinTree
     * @param output
     *            PrintWriter Obj
     */
    private void reversePreOrder(
        BinTreeNode cur,
        int level,
        int height,
        PrintWriter output) {
        if (cur.getClass() == LeafNode.class || cur == FlyweightNode.get()) {
            printNode(cur, level, height, output);
            return;
        }

        printNode(cur, level, height, output);
        reversePreOrder(((InternalNode)cur).getRight(), level + 1, height,
            output);
        reversePreOrder(((InternalNode)cur).getLeft(), level + 1, height,
            output);
    }


    /**
     * Method to print a node for BinTree
     * 
     * @param cur
     *            BinTreeNode
     * @param level
     *            level of the BinTreeNode
     * @param height
     *            height of the BinTree
     * @param output
     *            PrintWriter obj
     */
    private void printNode(
        BinTreeNode cur,
        int level,
        int height,
        PrintWriter output) {

        output.print(" ".repeat((height - level - 1) * 4));
        if (cur == FlyweightNode.get()) {
            output.println("(E)");
        }
        else if (cur.getClass() == LeafNode.class) {
            output.println("(Leaf with " + ((LeafNode)cur).getSeminars()
                .getNumNodes() + " objects: " + ((LeafNode)cur).getSeminars()
                    .printList() + ")");
        }
        else {
            output.println("(I)");
        }
    }


    private int getHeight(BinTreeNode cur) {
        if (cur.getClass() == LeafNode.class || cur == FlyweightNode.get()) {
            return 1;
        }

        int left = 1 + getHeight(((InternalNode)cur).getLeft());
        int right = 1 + getHeight(((InternalNode)cur).getRight());

        return Math.max(left, right);
    }


    /**
     * Getter for Root
     * 
     * @return root
     */
    public BinTreeNode getRoot() {
        return root;
    }


    /**
     * getter for worldSize
     * 
     * @return worldSize
     */
    public int getWorldSize() {
        return worldSize;
    }
}
