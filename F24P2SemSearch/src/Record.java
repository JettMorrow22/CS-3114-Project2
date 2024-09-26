/**
 * Record class
 *
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 9/24/2024
 * @param <T>
 *            declares which values the BSTNode key will hold
 */
public class Record<T extends Comparable<T>> {

    private T key;
    private Seminar seminar;

    public Record(T k, Seminar sem) {
        key = k;
        seminar = sem;
    }


    public T getKey() {
        return key;
    }


    public Seminar getSem() {
        return seminar;
    }


    public void setKey(T key) {
        this.key = key;
    }


    public void setSem(Seminar sem) {
        seminar = sem;
    }

}
