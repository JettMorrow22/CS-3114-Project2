import java.io.PrintWriter;

public class Controller {

    private BinarySearchTree<Integer> idTree;
    private BinarySearchTree<Integer> costTree;
    private BinarySearchTree<String> dateTree;
    private BinarySearchTree<String> keywordTree;

    public Controller(int worldSize) {
        idTree = new BinarySearchTree<>();
        costTree = new BinarySearchTree<>();
        dateTree = new BinarySearchTree<>();
        keywordTree = new BinarySearchTree<>();
    }


    // now have method for
    // insert only one method
    public void insertAllTrees(Seminar sem, PrintWriter output) {
        //add to four bst
        idTree.insert(new Record<Integer>(sem.id(), sem));
        costTree.insert(new Record<Integer>(sem.cost(), sem));
        dateTree.insert(new Record<String>(sem.date(), sem));
        for (String s : sem.keywords()) {
            keywordTree.insert(new Record<String>(s, sem));
        }
        
        output.println("Successfully inserted record with ID "
            + sem.id());
        output.println(sem.toString());
        
    }
    // delete
    
    
    // search id, cost, date, keyword, location
    public BSTNode<Integer> searchID(Record<Integer> id) {
        return idTree.find(id);
    }


    public BSTNode<Integer> searchCost(Record<Integer> cost) {
        return costTree.find(cost);
    }


    public BSTNode<String> searchDate(Record<String> date) {
        return dateTree.find(date);
    }


    public BSTNode<String> searhKeyword(Record<String> keyword) {
        return keywordTree.find(keyword);
    }
    // print

}
