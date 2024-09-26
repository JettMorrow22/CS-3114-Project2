import student.TestCase;

/**
 *  class to test BinarySearchTree
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Jett Morrow & Adam Schantz
 *  @version jettmorrow & adams03
 */
public class BinarySearchTreeTest extends TestCase
{
    //~ Fields ................................................................
    //private Seminar sem;
    private BinarySearchTree<Integer> search;
    private BSTNode<Integer> node;
    private Record<Integer> record;
    
    /**
     * setUp method for the test class
     */
    public void setUp()
    {
        record = new Record<Integer>(5, null);
        search = new BinarySearchTree<Integer>();
        node = new BSTNode<Integer>(record);
    }
    
    /**
     * test method for insert
     */
    public void testInsert()
    {
        search.insert(record);
        
        assertEquals(search.find(record), node);
    }

}
