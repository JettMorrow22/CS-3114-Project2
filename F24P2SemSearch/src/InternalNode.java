
/**
 * Internal Node class
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 10/14/2024
 */
public class InternalNode implements BinTreeNode {
    private BinTreeNode left;
    private BinTreeNode right;

    /**
     * Constructor for InternalNode
     * initializes left and right to flyweight node
     */
    public InternalNode() {
        left = FlyweightNode.get();
        right = FlyweightNode.get();
    }


    /**
     * Basic getter for Left
     * @return Left
     */
    public BinTreeNode getLeft() {
        return left;
    }


    /**
     * Basic getter for Right
     * @return Right
     */
    public BinTreeNode getRight() {
        return right;
    }


    /**
     * Basic setter for left
     * @param left new Left for BinTreeNode
     */
    public void setLeft(BinTreeNode left) {
        this.left = left;
    }


    /**
     * Basic setter for Right
     * @param right new Right BinTreeNode
     */
    public void setRight(BinTreeNode right) {
        this.right = right;
    }


    /**
     * Insert method for a InternalNode in the binTree
     * 
     * @param sem
     *            Seminar obj
     * @param x
     *            x point
     * @param y
     *            y point
     * @param width
     *            width of the box
     * @parma height height of the box
     * 
     * @return BinTreeNode determines if the seminar should go to left or right
     */
    @Override
    public BinTreeNode insert(
        Seminar sem,
        int x,
        int y,
        int width,
        int height) {
        // x is the discriminator
        if (width == height) {
            width = width / 2;
            // should it go to left or right
            if (sem.x() < x + width) {
                setLeft(getLeft().insert(sem, x, y, width, height));
            }
            else {
                setRight(getRight().insert(sem, x + width, y, width, height));
            }

        }
        else { // y is the discriminator
            height = height / 2;

            if (sem.y() < y + height) {
                setLeft(getLeft().insert(sem, x, y, width, height));
            }
            else {
                setRight(getRight().insert(sem, x, y + height, width, height));
            }
        }

        // should return its self
        return this;
    }


    @Override
    public int search(int x, int y, int radius, int bx, int by, int width, 
        int height) 
    {
        //do the boxes overlap
        //if ()
        return radius;
    }
    
    /**
     * whether or not an internal node should be visited
     * we need the box containing the node
     * @param x
     * @param y
     * @param r
     * @param bx the x dis
     * @param by the y dis
     * @param width of world
     * @param height of world
     * @return whether or not we need to check the internal node
     */
    public boolean withinBox(int x, int y, int r, int bx, 
        int by, int width, int height)
    {
        int ax = x-1;
        int ay = y-1;
        int w = 2*r + 1;
        int h = 2*r + 1;
        
        return true;
    }

}
