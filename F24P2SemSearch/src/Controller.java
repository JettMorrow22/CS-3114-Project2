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

        if (searchID(new Record<Integer>(sem.id(), sem)) == null) {
            // add to four bst
            idTree.insert(new Record<Integer>(sem.id(), sem));
            costTree.insert(new Record<Integer>(sem.cost(), sem));
            dateTree.insert(new Record<String>(sem.date(), sem));
            for (String s : sem.keywords()) {
                keywordTree.insert(new Record<String>(s, sem));
            }

            output.println("Successfully inserted record with ID " + sem.id());
            output.println(sem.toString());
        }
        else {
            // seminar already exists
            output.println("Insert FAILED - There is already a record with ID "
                + sem.id());
        }

    }


    // delete
    // for delete we are only given a ID from the id we can get the seminar
    public void delete(int id, PrintWriter output) {
        // determine if there is a seminar that has the id
        BSTNode<Integer> deletedNode = idTree.delete(new Record<Integer>(id,
            null));
        if (deletedNode != null) {
            // deletedNode gives us the seminar
            Seminar temp = deletedNode.getRecord().getSem();

            // create record with appriopriate key and this sem
            costTree.delete(new Record<Integer>(temp.cost(), temp));
            dateTree.delete(new Record<String>(temp.date(), temp));
            // delete all keywords from keywordTree
            Record<String> r = new Record<>(null, temp);
            for (String s : temp.keywords()) {
                r.setKey(s);
                keywordTree.delete(r);
            }
            output.println("Record with ID " + id
                + "successfully deleted from the database");
        }
        else {
            // node does not exist
            // print method
        }
    }


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
