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
    private Seminar sem;
    
    /**
     * setUp method for the test class
     */
    public void setUp()
    {
        String[] strings = new String[1];
        //20, "jett", "today", 5, 10, 10, 50, strings, "test"
        sem = new Seminar();
        record = new Record<Integer>(5, sem);
        search = new BinarySearchTree<Integer>();
        node = new BSTNode<Integer>(record);
    }
    
    /**
     * test method for insert
     */
    public void testInsert()
    {
        search.insert(record);
        System.out.println(record.getKey());
        System.out.println(search.find(record).getRecord().getKey());
        //System.out.println(record.getKey());
        //System.out.println(search.find(record).getRecord().getKey());
        System.out.println(record.getSem().id());
        System.out.println(search.find(record).getRecord().getSem().id());
        assertEquals(record.getSem(), search.find(record).getRecord().getSem());
        assertEquals(search.find(record), node);
    }

}
