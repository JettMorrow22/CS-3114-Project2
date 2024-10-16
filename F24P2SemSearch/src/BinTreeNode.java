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
     * search method
     * @param x
     * @param y
     * @param radius
     * @param bx the 
     * @return the number of nodes visited
     */
    public int search(int x, int y, int radius, int bx, int by, int width,
        int height);
    
    /**
     * helper method for determining if a node is within a boundary box
     * @param ax the box's xcoord
     * @param ay the box's ycoord
     * @param bx the node's xcoord
     * @param by the node's ycoord
     */

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
