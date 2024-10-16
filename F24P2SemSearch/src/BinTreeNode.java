/**
 * Interface for leafnode, internal node, and flyweightnode
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 10/12/2024
 */
public interface BinTreeNode {

    public BinTreeNode insert(Seminar sem, int x, int y, int width, int height);

    // ----------------------------------------------------------
    /**
     * delete method
     * @param sem the seminar we want to delete
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void delete(Seminar sem, int x, int y, int width, int height);
    
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
}
