import java.io.PrintWriter;
import student.TestCase;

/**
 * test class for BinTree
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 10/14/2024
 */
public class BinTreeTest extends TestCase {
    private BinTree bin;
    private Seminar one;
    private LeafNode oneLeaf;
    private Seminar two;
    private Seminar three;
    private Seminar four;
    private Seminar five;
    private PrintWriter output;
    
    private BinTree b2;

    /**
     * method to setup Seminars adn BinList
     */
    public void setUp() {
        bin = new BinTree(128);
        b2 = new BinTree(4);
        String[] keywords = { "keywords" };
        one = new Seminar(1, "title", "data", 1, (short)80, (short)30, 1,
            keywords, "description");
        two = new Seminar(2, "title", "data", 2, (short)50, (short)100, 2,
            keywords, "description");
        three = new Seminar(3, "title", "data", 3, (short)55, (short)70, 3,
            keywords, "description");
        // four = new Seminar(4, "title", "data", 4, (short)4, (short)4, 4,
        // keywords, "description");
        // five = new Seminar(5, "title", "data", 5, (short)5, (short)5, 5,
        // keywords, "description");

        oneLeaf = new LeafNode(one);
        output = new PrintWriter(System.out);
    }


    /**
     * testing with inserting different x and y
     */
    public void testInsert() {
        // empty binTree
        assertEquals(FlyweightNode.get(), bin.getRoot()); 
        assertEquals(128, bin.getWorldSize());

        // insert sem one
        bin.insert(one);
        assertEquals(bin.getRoot().getClass(), LeafNode.class);
        assertEquals(((LeafNode)bin.getRoot()).getSem(one), one);

        // insert sem two, should be two / Internal \ one
        bin.insert(two);
        assertEquals(bin.getRoot().getClass(), InternalNode.class);
        assertEquals(((InternalNode)bin.getRoot()).getLeft().getClass(),
            LeafNode.class);
        assertEquals(((LeafNode)((InternalNode)bin.getRoot()).getLeft()).getSem(
            two), two);
        assertEquals(((InternalNode)bin.getRoot()).getRight().getClass(),
            LeafNode.class);
        assertEquals(((LeafNode)((InternalNode)bin.getRoot()).getRight())
            .getSem(one), one);

        // insert sem three, internal / internal \ one
        // fly/ \internal
        // fly/ \ Internal
        // 3/ \2
        // need a y less than a square
        bin.insert(three);
    }


    /**
     * testing adding seminars with similar x and y values
     */
    public void testInsertSame() {
        // same x
        // same y
        // same x and y
        String[] keywords = { "Keyword" };
        Seminar sameX = new Seminar(4, "title", "data", 4, (short)80, (short)70,
            1, keywords, "description");
        Seminar sameY = new Seminar(5, "title", "data", 5, (short)20, (short)30,
            1, keywords, "description");
        Seminar sameXY = new Seminar(6, "title", "data", 6, (short)80,
            (short)30, 1, keywords, "description");

        bin.insert(one);

        bin.insert(sameX);
        InternalNode rightRoot = (InternalNode)((InternalNode)bin.getRoot())
            .getRight();
        assertEquals(((LeafNode)rightRoot.getRight()).getSem(sameX), sameX);
        assertEquals(((LeafNode)rightRoot.getLeft()).getSem(one), one);

        bin.insert(sameY);
        assertEquals(((LeafNode)((InternalNode)bin.getRoot()).getLeft()).getSem(
            sameY), sameY);

        bin.insert(sameXY);
        assertEquals(((LeafNode)rightRoot.getLeft()).getSem(one), one);
        assertEquals(((LeafNode)rightRoot.getLeft()).getSem(sameXY), sameXY);

        assertNull(((LeafNode)rightRoot.getLeft()).getSem(three));
    }


    /**
     * test delete
     */
    public void testDelete() {
        
        
        bin.insert(one);
        bin.insert(two);
        bin.insert(three);

        bin.delete(one);
        assertEquals(((InternalNode)bin.getRoot()).getRight(), FlyweightNode
            .get());

        bin.insert(one); // reset

        bin.delete(two);
        assertEquals(((LeafNode)((InternalNode)bin.getRoot()).getLeft()).getSem(
            three), three);

        bin.insert(two);
        bin.delete(three);
        assertEquals(((LeafNode)((InternalNode)bin.getRoot()).getLeft()).getSem(
            two), two);

        assertNull(FlyweightNode.get().delete(one, 0, 0, 0, 0));
    }


    /**
     * test delete with duplicates
     */
    public void testDeleteDuplicates() {
        
        String[] keywords = { "Keyword" };
        Seminar sameX = new Seminar(4, "title", "data", 4, (short)80, (short)70,
            1, keywords, "description");
        Seminar sameY = new Seminar(5, "title", "data", 5, (short)20, (short)30,
            1, keywords, "description");
        Seminar sameXY = new Seminar(6, "title", "data", 6, (short)80,
            (short)30, 1, keywords, "description");
        
        Seminar dup2 = new Seminar(2, "title", "data", 6, (short)80,
            (short)30, 1, keywords, "description");
        Seminar dup3 = new Seminar(3, "title", "data", 6, (short)80,
            (short)30, 1, keywords, "description");
        Seminar dup4 = new Seminar(4, "title", "data", 6, (short)80,
            (short)30, 1, keywords, "description");

        bin.insert(one);
        bin.insert(sameX);
        bin.insert(sameY);
        bin.insert(sameXY);
        bin.printTree(output);
        output.flush();

        InternalNode rightRoot = (InternalNode)((InternalNode)bin.getRoot())
            .getRight();

        bin.delete(sameXY);
        bin.printTree(output);
        output.flush();
        assertNull(((LeafNode)rightRoot.getLeft()).getSem(sameXY));
        assertEquals(((LeafNode)rightRoot.getLeft()).getSem(one), one);
        
        bin.insert(sameXY);
        bin.insert(dup2);
        bin.insert(dup3);
        bin.insert(dup4);
        bin.printTree(output);
        output.flush();
        
        bin.delete(dup3);
        bin.printTree(output);
        output.flush();
    }
    
    /**
     * test case for search
     */
    public void testSearch()
    {
        String[] keywords = { "Keyword" };
        assertEquals(1, bin.search(5, 5, 5, output));
        Seminar x1y0 = new Seminar(4, "title", "data", 4, (short)1, (short)0,
            1, keywords, "description");
        Seminar x1y2 = new Seminar(5, "title", "data", 5, (short)1, (short)2,
            1, keywords, "description");
        Seminar x2y1 = new Seminar(5, "title", "data", 5, (short)2, (short)1,
            1, keywords, "description");
        Seminar x2y2 = new Seminar(4, "title", "data", 4, (short)2, (short)2,

            1, keywords, "description");
        Seminar x2y3 = new Seminar(4, "title", "data", 4, (short)1, (short)0,
            1, keywords, "description");
        
        assertEquals(1, bin.search(5, 5, 20, output));
        b2.insert(x1y0);
        b2.insert(x1y2);
        b2.insert(x2y1);
        assertEquals(5, b2.search(1, 1, 1, output));
        assertEquals(3, b2.search(0, 0, 1, output));
        assertEquals(5, b2.search(2, 2, 1, output));
        
        b2.insert(x2y2);
        assertEquals(7, b2.search(2, 2, 1, output));
    }
}
