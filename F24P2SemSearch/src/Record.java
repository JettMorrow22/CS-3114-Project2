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

    /**
     * constructor for Record
     * @param k key
     * @param sem Seminar
     */
    public Record(T k, Seminar sem) {
        key = k;
        seminar = sem;
    }


    /**
     * getter for key
     * @return key
     */
    public T getKey() {
        return key;
    }


    /**
     * getter for Seminar
     * @return Seminar
     */
    public Seminar getSem() {
        return seminar;
    }


    /**
     * setter for Key
     * @param key key
     */
    public void setKey(T key) {
        this.key = key;
    }


    /**
     * setter for Seminar
     * @param sem Seminar
     */
    public void setSem(Seminar sem) {
        seminar = sem;
    }

}
