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

    /**
     * method to setup Seminars adn BinList
     */
    public void setUp() {
        bin = new BinTree(128);
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
}
