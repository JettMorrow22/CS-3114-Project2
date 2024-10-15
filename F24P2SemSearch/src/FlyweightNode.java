/**
 * FlyweightNode class
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 10/14/2024
 */
public class FlyweightNode implements BinTreeNode {

    private static final FlyweightNode FLYWEIGHT = new FlyweightNode();

    private FlyweightNode() {
        // does nothing but ensures no flyweightnodes are ever created
    }


    /**
     * getter for flyweightNode instance
     * 
     * @return FLYWEIGHT
     */
    public static FlyweightNode get() {
        return FLYWEIGHT;
    }


    /**
     * Insert method for a LeafNode in the flyweight node
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
     * @return a new leaf node with the seminar obj
     */
    @Override
    public BinTreeNode insert(
        Seminar sem,
        int x,
        int y,
        int width,
        int height) {
        // if we ever reach flyweight Node we can create insert a leafNode
        return new LeafNode(sem);
    }


    /**
     * delete method for flyweight node
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
     * @return null because it is never called
     */
    @Override
    public BinTreeNode delete(
        Seminar sem,
        int x,
        int y,
        int width,
        int height) {
        return null;
    }

}
