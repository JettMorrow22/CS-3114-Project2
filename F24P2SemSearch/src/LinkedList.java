
/**
 * Simple LinkedList class for seminars in leafNodes
 * 
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * 
 * @version 10/11/2024
 */
public class LinkedList {
    private LLNode head;
    private int numNodes;

    /**
     * basic constructor for linked list
     */
    public LinkedList() {
        head = null;
        numNodes = 0;
    }


    /**
     * creates new LLnode with sem and adds it to head of list
     * 
     * @param sem
     *            Seminar object
     */
    public void add(Seminar sem) {
        LLNode temp = new LLNode(sem, null);

        // list is empty of temp is smaller than head
        if (head == null || temp.getSeminar().id() < head.getSeminar().id()) {
            temp.setNext(head);
            head = temp;
        }
        else { // temp goes in the middle of the list
            LLNode cur = head;
            while (cur.getNext() != null && cur.getNext().getSeminar()
                .id() <= temp.getSeminar().id()) {
                cur = cur.getNext();
            }
            
            temp.setNext(cur.getNext());
            cur.setNext(temp);
        }
        numNodes++;
    }


    /**
     * removes LLNode with sem if it exists in the list
     * 
     * @param sem
     *            Seminar that is being removed from list
     * @return true if it is removed, false if it does not exist
     */
    public boolean remove(Seminar sem) {
        // list is empty
        if (head == null)
            return false;

        // head is removed
        if (head.getSeminar().id() == sem.id()) {
            head = head.getNext();
            numNodes--;
            return true;
        }

        // search for seminar in list
        LLNode prev = head;
        LLNode cur = head.getNext();
        while (cur != null) {
            if (cur.getSeminar().id() == sem.id()) {
                prev.setNext(cur.getNext());
                numNodes--;
                return true;
            }
            prev = cur;
            cur = cur.getNext();
        }

        // seminar not found
        return false;
    }


    /**
     * get LLNode that has sem if it exists
     * 
     * @param sem
     *            Seminar we are searching for
     * @return LLNode if it exists, null if the LLNode with sem DNE
     */
    public LLNode getLLNode(Seminar sem) {
        LLNode temp = head;
        while (temp != null) {
            if (temp.getSeminar().id() == sem.id()) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }
    
    /**
     * Returns String represenation of the Linked List
     * @return String of LinkedList
     */
    public String printList() {
        LLNode temp = head;
        StringBuilder s = new StringBuilder();
        while (temp.getNext() != null) {
            s.append(temp.getSeminar().id()).append(" ");
            temp = temp.getNext();
        }
        s.append(temp.getSeminar().id());
        return new String(s);
    }


    /**
     * getter for head
     * 
     * @return head
     */
    public LLNode getHead() {
        return head;
    }


    /**
     * getter for numNodes
     * 
     * @return numNodes
     */
    public int getNumNodes() {
        return numNodes;
    }

    /**
     * LLNode class for the LinkedList
     * 
     * 
     * @author Jett Morrow jettmorrow & Adam Schantz adams03
     * @version 10/12/2024
     */
    public class LLNode {
        private Seminar sem;
        private LLNode next;

        /**
         * basic constructor for LLNode
         * 
         * @param d
         *            seminar object for sem
         * @param n
         *            LLNode obj for next
         */
        public LLNode(Seminar d, LLNode n) {
            sem = d;
            next = n;
        }


        /**
         * getter for sem
         * 
         * @return sem
         */
        public Seminar getSeminar() {
            return sem;
        }


        /**
         * getter for next
         * 
         * @return next
         */
        public LLNode getNext() {
            return next;
        }


        /**
         * setter for next
         * 
         * @param n
         *            new next value
         */
        public void setNext(LLNode n) {
            next = n;
        }
    }
}
