import student.TestCase;

/**
 * Test class for linked list class
 *
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 10/12/2024
 */
public class LinkedListTest extends TestCase {

    private LinkedList list;
    private Seminar one;
    private Seminar two;
    private Seminar three;
    private Seminar four;
    private Seminar five;

    /**
     * Set up linked list and some seminars to test with
     */
    public void setUp() {
        list = new LinkedList();
        String[] keywords = { "keywords" };
        one = new Seminar(1, "title", "data", 1, (short)1, (short)1, 1,
            keywords, "description");
        two = new Seminar(2, "title", "data", 2, (short)2, (short)2, 2,
            keywords, "description");
        three = new Seminar(3, "title", "data", 3, (short)3, (short)3, 3,
            keywords, "description");
        four = new Seminar(4, "title", "data", 4, (short)4, (short)4, 4,
            keywords, "description");
        five = new Seminar(5, "title", "data", 5, (short)5, (short)5, 5,
            keywords, "description");

    }


    /**
     * test add method for linked list
     */
    public void testAdd() {
        assertNull(list.getHead());
        assertEquals(0, list.getNumNodes());

        list.add(one);
        assertEquals(list.getHead().getSeminar(), one);
        assertEquals(1, list.getNumNodes());

        list.add(two);
        assertEquals(list.getHead().getNext().getSeminar(), two);
        assertEquals(2, list.getNumNodes());
    }


    /**
     * test remove in LinkedList
     */
    public void testRemove() {
        // remove from empty list
        assertFalse(list.remove(one));

        list.add(five);
        list.add(four);
        list.add(three);
        list.add(two);
        list.add(one);

        // list is 1, 2, 3, 4, 5
        // remove head
        assertEquals(one, list.getHead().getSeminar());
        assertEquals(5, list.getNumNodes());
        assertTrue(list.remove(one));
        assertEquals(two, list.getHead().getSeminar());
        assertEquals(4, list.getNumNodes());

        // remove anything other than head
        assertTrue(list.remove(four));
        assertEquals(3, list.getNumNodes());

        // remove node that doesnt exist in list with elements
        assertFalse(list.remove(one));
        assertEquals(3, list.getNumNodes());
    }


    /**
     * test method for get
     */
    public void testGetLLNode() {
        list.add(five);
        list.add(four);
        list.add(three);
        list.add(two);
        list.add(one);

        assertEquals(one, list.getLLNode(one).getSeminar());
        assertEquals(two, list.getLLNode(two).getSeminar());
        assertEquals(three, list.getLLNode(three).getSeminar());
        assertEquals(four, list.getLLNode(four).getSeminar());
        assertEquals(five, list.getLLNode(five).getSeminar());

        list.remove(three);
        assertNull(list.getLLNode(three));
    }
}
