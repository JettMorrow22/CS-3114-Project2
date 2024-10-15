/**
 * Interface for leafnode, internal node, and flyweightnode
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 10/12/2024
 */
public interface BinTreeNode {

    public BinTreeNode insert(Seminar sem, int x, int y, int width, int height);

    // public void delete(Seminar sem, int x, int y, int width, int height);
}
