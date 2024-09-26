import student.TestCase;

/**
 * test class for record
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * 
 * @version 9/24/2024
 */
public class RecordTest extends TestCase {

    private Record<Integer> record;
    private Seminar sem;
    private Seminar sem2;

    /**
     * set up our fields
     */
    public void setUp() {
        sem = new Seminar();
        sem2 = new Seminar();
        record = new Record<>(5, sem);
    }


    /**
     * test for get and set key
     */
    public void testKey() {
        assertEquals(5, (int)record.getKey());
        record.setKey(100);
        assertEquals(100, (int)record.getKey());
    }


    /**
     * test for get and set Seminar
     */
    public void testSeminar() {
        assertEquals(sem, record.getSem());
        record.setSem(sem2);
        assertEquals(sem2, record.getSem());
    }
}
