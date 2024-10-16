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
    
    /**
     * searchLocation method implementation
     * search all subtrees within a radius of a starting point
     * @param x xcoord
     * @param y ycoord
     * @param radius of how far we want to search
     * @return records within radius
     */
    public int search(int x, int y, int radius)
    {
        //need to get the number of records within the radius, and track how 
        //many nodes were visited
        //create a boundary box?
        return 0;
    }
    
    /**
     * helper method for search
     * @param x xcoord
     * @param y ycoord
     * @param radius of how far we want to search
     */
    private int helpSearch(int x, int y, int r) 
    {
        int ax = x - 1;
        int ay = y - 1;
        int w = 2*r + 1;
        int h = 2*r + 1;
        return 0;
        //return root.search(ax, ay, w, h);
        //this will be the search method implemented in each node class
    }
}
