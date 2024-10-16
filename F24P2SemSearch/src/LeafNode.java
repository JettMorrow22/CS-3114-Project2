import java.io.PrintWriter;

/**
 * LeafNode class
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 10/14/2024
 */
public class LeafNode
    implements BinTreeNode
{

    private LinkedList seminars;

    /**
     * Basic constructor for LeafNode adds seminar to the LinkedList
     * 
     * @param sem
     *            Seminar obj
     */
    public LeafNode(Seminar sem)
    {
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
    public Seminar getSem(Seminar s)
    {
        LinkedList.LLNode temp = seminars.getLLNode(s);
        if (temp == null)
        {
            return null;
        }
        return temp.getSeminar();
    }


    /**
     * getter for seminars
     * 
     * @return seminars
     */
    public LinkedList getSeminars()
    {
        return seminars;
    }


    /**
     * Insert method for a LeafNode in the binTree
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
     * @return BinTreeNode returns a internal node with leafnodes as its
     *             children
     */
    @Override
    public BinTreeNode insert(Seminar sem, int x, int y, int width, int height)
    {

        // x and y already exist so add it to seminars, and do not add to node
        // count in bin tree
        if (seminars.getHead().getSeminar().x() == sem.x()
            && seminars.getHead().getSeminar().y() == sem.y())
        {
            seminars.add(sem);
            return this;
        }

        // create internal and add all seminars in this node to it, then add sem
        InternalNode temp = new InternalNode();
        LinkedList.LLNode cur = seminars.getHead();
        while (cur != null)
        {
            temp.insert(cur.getSeminar(), x, y, width, height);
            cur = cur.getNext();
        }
        temp.insert(sem, x, y, width, height);
        return temp;
    }


    /**
     * Delete method for LeafNode
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
     * @return returns flyweight node is seminars is empty after removal, or
     *             itsself
     */
    @Override
    public BinTreeNode delete(Seminar sem, int x, int y, int width, int height)
    {
        // remove seminar from the LinkedList
        seminars.remove(sem);
        // if seminars is empty return flyweight node
        if (seminars.getNumNodes() == 0)
        {
            return FlyweightNode.get();
        }
        // if not rempty return its self
        return this;
    }


    @Override
    public int search(
        int x,
        int y,
        int radius,
        int bx,
        int by,
        int width,
        int height,
        PrintWriter output)
    {
        LinkedList.LLNode cur = seminars.getHead();
        while (cur != null)
        {
            Seminar seminar = cur.getSeminar();
            if ((withinRange(x, y, radius, seminar.x(), seminar.y())))
            {
                // print the seminar
                output.println(
                    "Found a record with key value " + seminar.id() + " at "
                        + seminar.x() + ", " + seminar.y());
            }
            cur = cur.getNext();
        }

        return 1;
    }


    /**
     * helper method for search
     */
    private boolean withinRange(int x, int y, int radius, int ax, int ay)
    {
        if ((x - ax) * (x - ax) + (y - ay) * (y - ay) <= (radius * radius))
        {
            return true;
        }
        return false;
    }
}
