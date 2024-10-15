
public class LeafNode implements BinTreeNode {

    private LinkedList seminars;

    public LeafNode(Seminar sem) {
        seminars = new LinkedList();
        seminars.add(sem);
    }


    @Override
    public BinTreeNode insert(
        Seminar sem,
        int x,
        int y,
        int width,
        int height) {

        // x and y already exist so add it to seminars, and do not add to node
        // count in bin tree
        if (seminars.getHead().getSeminar().x() == x && seminars.getHead()
            .getSeminar().y() == y) {
            seminars.add(sem);
            return this;
        }
        
        //create internal and add all seminars in this node to it, then add sem
        InternalNode temp = new InternalNode();
        LinkedList.LLNode cur = seminars.getHead();
        while (cur != null) {
            temp.insert(cur.getSeminar(), x, y, width, height);
        }
        temp.insert(sem, x, y, width, height);
        return temp;
    }


    @Override
    public void delete(Seminar sem, int x, int y, int width, int height) {
        // TODO Auto-generated method stub

    }
}
