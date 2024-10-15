/**
 * LeafNode class
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 10/14/2024
 */
public class LeafNode implements BinTreeNode {

    private LinkedList seminars;

    /**
     * Basic constructor for LeafNode adds seminar to the LinkedList
     * 
     * @param sem
     */
    public LeafNode(Seminar sem) {
        seminars = new LinkedList();
        seminars.add(sem);
    }


    /**
     * grabs the seminar from seminars if it exists
     * 
     * @param s
     *            seminar
     * @return the Seminar if it exists, Null if it DNE
     */
    public Seminar getSem(Seminar s) {
        LinkedList.LLNode temp = seminars.getLLNode(s);
        if (temp == null) {
            return null;
        }
        return temp.getSeminar();
    }
    
    /**
     * getter for Seminars
     * @return seminars
     */
    public LinkedList getSeminars() {
        return seminars;
    }


    /**
     * Insert method for a LeafNode in the binTree
     * 
     * @param sem Seminar obj
     * @param x x point
     * @param y y point
     * @param width width of the box
     * @parma height height of the box
     * 
     * @return BinTreeNode returns a internal node with leafnodes as its
     *         children
     */
    public BinTreeNode insert(
        Seminar sem,
        int x,
        int y,
        int width,
        int height) {

        // x and y already exist so add it to seminars, and do not add to node
        // count in bin tree
        if (seminars.getHead().getSeminar().x() == sem.x() && seminars.getHead()
            .getSeminar().y() == sem.y()) {
            seminars.add(sem);
            return this;
        }

        // create internal and add all seminars in this node to it, then add sem
        InternalNode temp = new InternalNode();
        LinkedList.LLNode cur = seminars.getHead();
        while (cur != null) {
            temp.insert(cur.getSeminar(), x, y, width, height);
            cur = cur.getNext();
        }
        temp.insert(sem, x, y, width, height);
        return temp;
    }


//    @Override
//    public void delete(Seminar sem, int x, int y, int width, int height) {
//        // TODO Auto-generated method stub
//
//    }
}
