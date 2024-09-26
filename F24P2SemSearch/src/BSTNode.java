/**
 * BSTNode
 *
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 9/24/2024
 * @param <T>
 *            declares data data type
 */
public class BSTNode<T extends Comparable<T>> {

    private Record<T> record;
    private BSTNode<T> left;
    private BSTNode<T> right;

    /**
     * constructor for BSTNode
     * 
     * @param r
     *            data
     */
    public BSTNode(Record<T> r) {
        record = r;
        left = null;
        right = null;
    }


    /**
     * basic getter for data
     * 
     * @return data
     */
    public Record<T> getRecord() {
        return record;
    }


    /**
     * basic getter for Left
     * 
     * @return left
     */
    public BSTNode<T> getLeft() {
        return left;
    }


    /**
     * basic getter for right
     * 
     * @return right
     */
    public BSTNode<T> getRight() {
        return right;
    }


    /**
     * basic setter for Data
     * 
     * @param data
     *            new Data
     */
    public void setData(Record<T> r) {
        this.record = r;
    }


    /**
     * basic setter for Lef
     * 
     * @param left
     *            new Left
     */
    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }


    /**
     * basis setter for right
     * 
     * @param right
     *            new Right
     */
    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

}
