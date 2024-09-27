import java.io.PrintWriter;
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
    private PrintWriter output;
    
    /**
     * setUp method for the test class
     */
    public void setUp()
    {
        String[] strings = new String[1];
        //20, "jett", "today", 5, 10, 10, 50, strings, "test"
        short x = 10;
        short y = 10;
        sem = new Seminar(20, "jett", "today", 5, x, y, 50, strings, "test");
        record = new Record<Integer>(5, sem);
        search = new BinarySearchTree<Integer>();
        node = new BSTNode<Integer>(record);
        
        output = new PrintWriter(System.out);

    }
    
    /**
     * test method for insert
     */
    public void testInsert()
    {
        search.insert(record);
        
        assertEquals(1, search.getNumberOfNodes());
        assertEquals((int) record.getKey(),
            (int) search.find(record).getRecord().getKey());
        assertEquals(record.getSem(), search.find(record).getRecord().getSem());
        
        Record<Integer> rec1 = new Record<Integer>(6, sem);
        search.insert(rec1);
        assertEquals((int) search.find(rec1).getRecord().getKey(), 6);
        
        Record<Integer> rec2 = new Record<Integer>(4, sem);
        search.insert(rec2);
        assertEquals((int) search.find(rec2).getRecord().getKey(), 4);
        
        Record<Integer> rec3 = new Record<Integer>(8, sem);
        search.insert(rec3);
        
        output.println("hello");
        search.printTree(output);
        output.flush();
    }
    
    /**
     * test method for find
     */
    public void testFind()
    {
        Seminar sem1 = new Seminar();
        Record<Integer> rec1 = new Record<Integer>(5, sem1);
        assertNull(search.find(record));
        search.insert(record);
        search.insert(rec1);
        search.find(rec1);
    }
    
    /**
     * test method for delete
     */
    public void testDelete()
    {
        search.insert(record);
        search.delete(record);
        assertNull(search.find(record));
        assertNull(search.delete(record));
        
        Record<Integer> rec1 = new Record<Integer>(6, sem);
        Record<Integer> rec2 = new Record<Integer>(4, sem);
        Record<Integer> rec5 = new Record<Integer>(7, sem);
        Record<Integer> rec6 = new Record<Integer>(8, sem);
        
        search.insert(record);
        search.insert(rec2);
        search.insert(rec1);
        search.delete(rec1);
        assertNull(search.find(rec1));
        search.delete(rec2);
        assertNull(search.find(rec2));
        
        search.insert(rec5);
        search.insert(rec1);
        search.insert(rec6);
        search.delete(rec6);
        
        short xcoord = 12;
        short ycoord = 12;
        String[] stringarr = new String[3];
        Seminar sem1 = new Seminar(15, "jett", "today", 5, 
            xcoord, ycoord, 50, stringarr, "test");
        Seminar sem2 = new Seminar(16, "jett", "today", 5, 
            xcoord, ycoord, 50, stringarr, "test");
        Record<Integer> rec3 = new Record<Integer>(5, sem1);
        Record<Integer> rec4 = new Record<Integer>(5, sem1);
        
        search.insert(rec3);
        search.delete(rec3);
        assertNull(search.find(rec3));
    }
    
}
