public class BinTree {
    
    private BinTreeNode root;
    private int numberOfNodes;
    private int worldSize;
    
    
    public BinTree(int size) {
        root = FlyweightNode.get();
        numberOfNodes = 0;
        worldSize = size;
    }
    
    
    public void insert(Seminar sem) {
        root = helpInsert(sem);
        numberOfNodes++;
    }
    
    private BinTreeNode helpInsert(Seminar sem) {
        return root.insert(sem, 0, 0, worldSize, worldSize);
    }


    public BinTreeNode getRoot() {
        return root;
    }


    public int getNumberOfNodes() {
        return numberOfNodes;
    }


    public int getWorldSize() {
        return worldSize;
    }


    public void setRoot(BinTreeNode root) {
        this.root = root;
    }  
}
