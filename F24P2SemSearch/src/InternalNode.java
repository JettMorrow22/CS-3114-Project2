
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
     * 
     * @return Left
     */
    public BinTreeNode getLeft() {
        return left;
    }


    /**
     * Basic getter for Right
     * 
     * @return Right
     */
    public BinTreeNode getRight() {
        return right;
    }


    /**
     * Basic setter for left
     * 
     * @param left
     *            new Left for BinTreeNode
     */
    public void setLeft(BinTreeNode left) {
        this.left = left;
    }


    /**
     * Basic setter for Right
     * 
     * @param right
     *            new Right BinTreeNode
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


    /**
     * delete method for Internal Node
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
     * @return returns its self it it has two leaf node children
     *         returns leaf node if one child is leaf and the other is
     *         flyweightNode
     */
    @Override
    public BinTreeNode delete(
        Seminar sem,
        int x,
        int y,
        int width,
        int height) {

        if (width == height) {
            width = width / 2;
            if (sem.x() < x + width) {
                setLeft(getLeft().delete(sem, x, y, width, height));
            }
            else {
                setRight(getRight().delete(sem, x + width, y, width, height));
            }
        }
        else {
            height = height / 2;
            if (sem.y() < y + height) {
                setLeft(getLeft().delete(sem, x, y, width, height));
            }
            else {
                setRight(getRight().delete(sem, x, y + height, width, height));
            }
        }

        // if one child is fly and other is leaf then return that leaf other
        if (getLeft().getClass() == LeafNode.class
            && getRight() == FlyweightNode.get()) {
            return getLeft();
        }
        else if (getLeft() == FlyweightNode.get() && getRight()
            .getClass() == LeafNode.class) {
            return getRight();
        }
        return this;
    }

}
