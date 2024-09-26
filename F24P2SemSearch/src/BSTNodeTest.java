import student.TestCase;

/**
 * test class for BSTNode
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * 
 * @version 9/24/2024
 */
public class BSTNodeTest extends TestCase {
    private BSTNode<Integer> node;
    private Record<Integer> record;
    private Seminar sem;
    
    private Record<Integer> record2;
    private Seminar sem2;
    
    /**
     * set up fields
     */
    public void setUp() {
        sem = new Seminar();
        sem2 = new Seminar();
       
        record = new Record<>(5, sem);
        record2 = new Record<>(10, sem2);
        
        node = new BSTNode<>(record);
    }
    
    /**
     * test method for get and set record
     */
    public void testRecord() {
        assertEquals(record, node.getRecord());
        node.setRecord(record2);
        assertEquals(record2, node.getRecord());
    }
    
    /**
     * test method for get and set left
     */
    public void testLeft() {
        assertNull(node.getLeft());
        BSTNode temp = new BSTNode<>(record2);
        node.setLeft(temp);
        assertEquals(node.getLeft(), temp);
        
    }
    
    /**
     * test method for get and set right
     */
    public void testRight() {
        assertNull(node.getRight());
        BSTNode temp = new BSTNode<>(record2);
        node.setRight(temp);
        assertEquals(node.getRight(), temp);
        
    }
}
