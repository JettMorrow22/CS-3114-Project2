import java.io.PrintWriter;

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
     * Constructor for InternalNode initializes left and right to flyweight node
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
     * internal nodes determines which nodes we should search
     * 
     * @param x
     *            x of seminar
     * @param y
     *            y of seminar
     * @param radius
     *            radius of search
     * @param bx
     *            x of where we are in the bin tree
     * @param by
     *            y of where we are in the bin tree
     * @param width
     *            width of bin tree
     * @param height
     *            height of bin tree\
     * @param output
     *            Printwriter output
     * @return the nodes visited in the search
     */
    @Override
    public int search(
        int x,
        int y,
        int radius,
        int bx,
        int by,
        int width,
        int height,
        PrintWriter output) {

        int boundingTopLeftX = x - radius;
        int boundingTopLeftY = y - radius;
        if (width == height) {
            // x is discriminator
            width = width / 2;
            // box is completely less than discriminator
            if (boundingTopLeftX + radius + radius < bx + width) {
                return 1 + getLeft().search(x, y, radius, bx, by, width, height,
                    output);
            }
            else if (boundingTopLeftX > bx + width) { // greater than or equal
                return 1 + getRight().search(x, y, radius, bx + width, by,
                    width, height, output);
            }
            else { // in the middle (go left and right)
                return 1 + getLeft().search(x, y, radius, bx, by, width, height,
                    output) + getRight().search(x, y, radius, bx + width, by,
                        width, height, output);
            }
        }
        else {
            // y is discriminator\
            height = height / 2;
            // above it
            if (boundingTopLeftY + radius + radius < by + height) {
                return 1 + getLeft().search(x, y, radius, bx, by, width, height,
                    output);
            }
            else if (boundingTopLeftY > by + height) { // below it
                return 1 + getRight().search(x, y, radius, bx, by + height,
                    width, height, output);
            }
            else { // both
                return 1 + getLeft().search(x, y, radius, bx, by, width, height,
                    output) + getRight().search(x, y, radius, bx, by + height,
                        width, height, output);
            }
        }
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
     * @return returns its self it it has two leaf node children returns leaf
     *         node if one child is leaf and the other is flyweightNode
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
