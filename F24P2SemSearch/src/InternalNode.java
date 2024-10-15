
public class InternalNode implements BinTreeNode {
    private BinTreeNode left;
    private BinTreeNode right;
    
    public InternalNode() {
        left = FlyweightNode.get();
        right = FlyweightNode.get();
    }

    public BinTreeNode getLeft() {
        return left;
    }

    public BinTreeNode getRight() {
        return right;
    }

    public void setLeft(BinTreeNode left) {
        this.left = left;
    }

    public void setRight(BinTreeNode right) {
        this.right = right;
    }

    @Override
    public BinTreeNode insert(Seminar sem, int x, int y, int width, int height) {
        //x is the discriminator
        if (width == height) {
            width = width / 2;
            //should it go to left or right
            if (sem.x() + x < width) {
                setLeft(getLeft().insert(sem, x, y, width, height));
            }
            else {
                setRight(getRight().insert(sem, x + width, y, width, height));
            }
            
        }
        else { //y is the discriminator
            height = height / 2;
            
            if (sem.y() + y < height) {
                setLeft(getLeft().insert(sem, x, y, width, height));
            }
            else {
                setRight(getRight().insert(sem, x, y + height, width, height));
            }
        }
        
        //should return its self
        return this;
    }

    @Override
    public void delete(Seminar sem, int x, int y, int width, int height) {
        // TODO Auto-generated method stub
        
    }  
    
}
