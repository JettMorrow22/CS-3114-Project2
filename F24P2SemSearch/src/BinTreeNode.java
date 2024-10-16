import java.io.PrintWriter;

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
     * 
     * @param x
     *            x of seminar
     * @param y
     *            y of seminar
     * @param radius
     *            radius search
     * @param bx
     *            the x of bin tree
     * @param by
     *            the y of bin tree
     * @param width
     *            width of bin tree
     * @param height
     *            of bin tree
     * @param output
     *            PrintWriter output
     * @return the number of nodes visited
     */
    public int search(
        int x,
        int y,
        int radius,
        int bx,
        int by,
        int width,
        int height,
        PrintWriter output);


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
