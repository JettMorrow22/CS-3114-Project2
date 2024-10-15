
public class FlyweightNode implements BinTreeNode {
    
    private static final FlyweightNode flyweight = new FlyweightNode();
    
    private FlyweightNode() {
        //does nothing but ensures no flyweightnodes are ever created
    }
    
    public static FlyweightNode get() {
        return flyweight;
    }

    @Override
    public BinTreeNode insert(Seminar sem, int x, int y, int width, int height) {
        //if we ever reach flyweight Node we can create insert a leafNode
        return new LeafNode(sem);
    }

    @Override
    public void delete(Seminar sem, int x, int y, int width, int height) {
        // TODO Auto-generated method stub

    }

}
