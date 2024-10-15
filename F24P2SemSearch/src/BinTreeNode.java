/**
 * Interface for leafnode, internal node, and flyweightnode
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 10/12/2024
 */
public interface BinTreeNode {

    /**
     * insert method for all BinTreeNodes
     * 
     * @param sem
     *            Seminar obj
     * @param x
     *            cur x value
     * @param y
     *            cur y value
     * @param width
     *            cur width
     * @param height
     *            cur height
     * @return BinTreeNode
     */
    public BinTreeNode insert(Seminar sem, int x, int y, int width, int height);


    /**
     * delete method for all BinTreeNodes
     * 
     * @param sem
     *            Seminar obj
     * @param x
     *            cur x value
     * @param y
     *            cur y value
     * @param width
     *            cur width
     * @param height
     *            cur height
     * @return BinTreeNode
     */
    public BinTreeNode delete(Seminar sem, int x, int y, int width, int height);
}
