
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
    
    public LinkedList() {
        head = null;
        numNodes = 0;
    }
    
    public void add(Seminar sem) {
        LLNode temp = new LLNode(sem, head);
        head = temp;
        numNodes++;
    }
    
    public boolean delete(Seminar sem) {
        //list is empty
        if (head == null) return false;
        
        //head is removed
        if (head.getSeminar().id() == sem.id()) {
            head = head.next;
            numNodes--;
            return true;
        }
        
        //search for seminar in list
        LLNode prev = head;
        LLNode cur = head.next;
        while (cur != null) {
            if (cur.getSeminar().id() == sem.id()) {
                prev.setNext(cur.getNext());
                numNodes--;
                return true;
            }
            prev = cur;
            cur = cur.getNext();
        }
        
        //seminar not found
        return false;
    }
    
    public LLNode getHead() {
        return head;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public class LLNode {
        private Seminar sem;
        private LLNode next;
        
        public LLNode(Seminar d, LLNode n ) {
            sem = d;
            next = n;
        }
        
        public Seminar getSeminar() {
            return sem;
        }
        
        public LLNode getNext() {
            return next;
        }
        
        public void setSeminar(Seminar s) {
            sem = s;
        }
        
        public void setNext(LLNode n) {
            next = n;
        }
    }
}
