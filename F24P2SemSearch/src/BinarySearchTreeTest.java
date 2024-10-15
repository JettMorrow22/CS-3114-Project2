import java.io.PrintWriter;
import student.TestCase;
import java.io.StringWriter;

/**
 * class to test BinarySearchTree
 * Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author Jett Morrow & Adam Schantz
 * @version jettmorrow & adams03
 */
public class BinarySearchTreeTest extends TestCase {
    // ~ Fields ................................................................
    // private Seminar sem;
    private BinarySearchTree<Integer> search;
    private BSTNode<Integer> node;
    private Record<Integer> record;
    private Seminar sem;
    private PrintWriter output;

    private BinarySearchTree<Integer> bst;
    private Record<Integer> record1;
    private Record<Integer> record2;
    private Record<Integer> record3;
    private Record<Integer> record4;

    /**
     * setUp method for the test class
     */
    public void setUp() {
        String[] strings = new String[1];
        // 20, "jett", "today", 5, 10, 10, 50, strings, "test"
        short x = 10;
        short y = 10;
        sem = new Seminar(20, "jett", "today", 5, x, y, 50, strings, "test");
        record = new Record<Integer>(5, sem);
        search = new BinarySearchTree<Integer>();
        node = new BSTNode<Integer>(record);

        output = new PrintWriter(System.out);

        bst = new BinarySearchTree<>();
        Seminar seminar1 = new Seminar(1, "Intro to Algorithms", "2024-01-01",
            60, (short)1, (short)1, 100, new String[] { "algorithms", "CS" },
            "Learn about algorithms.");
        Seminar seminar2 = new Seminar(2, "Data Structures", "2024-02-01", 90,
            (short)2, (short)2, 150, new String[] { "data structures", "CS" },
            "Study various data structures.");
        Seminar seminar3 = new Seminar(3, "Software Engineering", "2024-03-01",
            120, (short)3, (short)3, 200, new String[] { "software",
                "engineering" }, "Explore software development.");
        Seminar seminar4 = new Seminar(1, "Advanced Algorithms", "2024-01-15",
            60, (short)4, (short)4, 100, new String[] { "algorithms",
                "advanced" }, "Deep dive into algorithms.");

        record1 = new Record<>(10, seminar1);
        record2 = new Record<>(5, seminar2);
        record3 = new Record<>(15, seminar3);
        record4 = new Record<>(7, seminar4);

        // Inserting records into the BST
        bst.insert(record1);
        bst.insert(record2);
        bst.insert(record3);
        bst.insert(record4);
    }


    /**
     * test method for insert
     */
    public void testInsert() {
        assertNotNull(bst.find(record1));
        assertNotNull(bst.find(record2));
        assertNotNull(bst.find(record3));
        assertNotNull(bst.find(record4));

        assertEquals(4, bst.getNumberOfNodes());
        assertTrue(4 == bst.getNumberOfNodes());

    }


    /**
     * test method for find
     */
    public void testFind() {
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
    public void testDelete() {
        assertNotNull(bst.find(record4)); // Before deletion
        bst.delete(record4);
        assertNull(bst.find(record4));

        Record<Integer> rec1 = new Record<Integer>(6, sem);
        Record<Integer> rec2 = new Record<Integer>(4, sem);
        Record<Integer> rec3 = new Record<Integer>(3, sem);
        Record<Integer> rec5 = new Record<Integer>(7, sem);
        Record<Integer> rec6 = new Record<Integer>(8, sem);

        // delete from empty tree
        assertNull(search.delete(null));

        search.insert(record);
        search.insert(rec2);
        search.insert(rec1);
        search.delete(rec1);
        assertNull(search.find(rec1));
        assertTrue(2 == search.getNumberOfNodes());

        search.insert(rec1);
        search.insert(rec5);

        // only right child
        search.delete(rec5);
        assertTrue(3 == search.getNumberOfNodes());
        
        //only left child
        search.insert(rec3);
        search.delete(rec3);
        assertTrue(3 == search.getNumberOfNodes());

        search.delete(rec2);
        assertTrue(2 == search.getNumberOfNodes());
        assertNull(search.find(rec2));

        search.insert(rec5);
        search.insert(rec1);
        search.insert(rec6);
        search.insert(rec2);
        search.delete(rec6);
        assertNull(search.find(rec6));

        short xcoord = 12;
        short ycoord = 12;
        String[] stringarr = new String[3];
        Seminar sem1 = new Seminar(15, "jett", "today", 5, xcoord, ycoord, 50,
            stringarr, "test");
    }


    /**
     * another test delete method, node with one child
     */
    public void testDeleteOneChild() {
        bst.delete(record2); // Record with one child (5)
        assertNull(bst.find(record2)); // Should be deleted
        assertNotNull(bst.find(record1)); // Other nodes should still exist
        assertNotNull(bst.find(record3)); // Ensure structure is maintained
    }


    /**
     * another test delete method
     */
    public void testDeleteTwoChildren() {
        bst.delete(record1); // Record with two children (10)
        assertNull(bst.find(record1)); // Should be deleted
        assertNotNull(bst.find(record2)); // Check if left child remains
        assertNotNull(bst.find(record3)); // Check if right child remains
    }


    /**
     * delete a non existent node
     */
    public void testDeleteNonExistentNode() {
        Record<Integer> nonExistentRecord = new Record<>(100, new Seminar(4,
            "Non-existent Seminar", "2024-12-01", 60, (short)5, (short)5, 50,
            new String[] { "none" }, "This seminar does not exist."));
        assertNull(bst.delete(nonExistentRecord)); // Trying to delete a
                                                   // non-existent record
        assertTrue(4 == bst.getNumberOfNodes());
    }


    /**
     * test method for print
     */
    public void testPrintTree() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        bst.printTree(pw);
        pw.flush();
        String output1 = 
              "    (null)\r\n"
            + "        \\\r\n"
            + "        (5)\r\n"
            + "        /\r\n"
            + "(null)\r\n"
            + "    \\\r\n"
            + "    (7)\r\n"
            + "    /\r\n"
            + "(null)\r\n"
            + "            \\\r\n"
            + "            (10)\r\n"
            + "            /\r\n"
            + "    (null)\r\n"
            + "        \\\r\n"
            + "        (15)\r\n"
            + "        /\r\n"
            + "    (null)\r\n"
            + "Number of records: 4\n";
        
        //remove all nodes for empty tree
        bst.delete(record1);
        bst.delete(record2);
        bst.delete(record3);
        bst.delete(record4);
        bst.printTree(pw);
        
        output1 += "This tree is empty\n";
        assertEquals(output1, sw.toString());
            
    }


    /**
     * test method for get and delete max
     */
    public void testGetMax() {
        BSTNode<Integer> maxNode = bst.getMax(bst.getRoot());
        assertNotNull(maxNode);
        assertTrue(record3.getKey() == maxNode.getRecord().getKey()); // Should
                                                                      // be "15"
    }


    /**
     * test method for deleteMax
     */
    public void testDeleteMax() {
        // Deleting the maximum value and checking the tree structure afterward
        bst.deleteMax(bst.getRoot());
        assertNull(bst.find(record3)); // The maximum node should be deleted

        // Check if the remaining nodes still exist
        assertNotNull(bst.find(record1)); // "10" should still exist
        assertNotNull(bst.find(record2)); // "5" should still exist
        assertNotNull(bst.find(record4)); // "7" should still exist

        // Check if the new maximum is now correct
        BSTNode<Integer> newMaxNode = bst.getMax(bst.getRoot());
        assertNotNull(newMaxNode);
        assertTrue(record1.getKey() == 
            newMaxNode.getRecord().getKey()); // New max should be "10"

    }


    /**
     * test method for findFromKey
     */
    public void testFindFromKey() {

        // test smaller existing key
        BSTNode<Integer> smaller = bst.findFromKey(5);
        assertNotNull(smaller);
        assertTrue(5 == smaller.getRecord().getKey());

        // Test greater than an existing key
        BSTNode<Integer> foundNode = bst.findFromKey(10);
        assertNotNull(foundNode);
        assertTrue(record1.getKey() == foundNode.getRecord().getKey());

        // Test finding a non-existing key
        BSTNode<Integer> notFoundNode = bst.findFromKey(999);
        assertNull(notFoundNode);
    }


    /**
     * test method for range
     */
    public void testRange() {
        StringWriter output2 = new StringWriter();
        PrintWriter printWriter = new PrintWriter(output2);

        // Check range that includes some nodes
        int count = bst.range(bst.getRoot(), 5, 15, printWriter);
        assertTrue(8 == count); // There are 7 nodes in the range

        printWriter.flush();

        // Check printed output
        String expectedOutput = record2.getSem().toString() + "\n" + record4
            .getSem().toString() + "\n" + record1.getSem().toString() + "\n"
            + record3.getSem().toString() + "\n";
        assertEquals(expectedOutput, output2.toString());

        // Reset output for another test
        output2 = new StringWriter();
        printWriter = new PrintWriter(output2);

        // Check range that includes no nodes
        count = bst.range(bst.getRoot(), 20, 30, printWriter);
        assertTrue(3 == count); // No nodes in this range
        assertEquals("", output2.toString()); // No output should be produced
    }
}
