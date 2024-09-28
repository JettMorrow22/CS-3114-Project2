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

        // if we dont have record with id
        if (idTree.findFromKey(sem.id()) == null) {
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

    // ----------------------------------------------------------------
    // okay when deleting we are given a ID and we have to remove that seminar
    // from all the other trees, \
    // there can be duplicate cost, keyword, and date so we check seminar
    // if we delete the id, then we get the seminar and easy

    // what if I could find something just off its key

    // delete something based off its id
    // so find it in idTree to get record and sem, then use that record to
    // delete it from other trees

    // delete
    // for delete we are only given a ID from the id we can get the seminar
    // we need a way of getting the record just given id


    public void delete(int id, PrintWriter output) {
        // determine if there is a seminar that has the id
        BSTNode<Integer> deletedNode = idTree.delete(idTree.findFromKey(id)
            .getRecord());
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
                + " successfully deleted from the database");
        }
        else {
            // node does not exist
            // print method
            output.println("Delete FAILED -- There is not record with ID "
                + id);
        }
    }


    /**
     * method to search idBST for id
     * 
     * @param id
     *            id being searched
     * @return BSTNode that has the id & seminar or null
     */
    public void searchID(int id, PrintWriter output) {
        BSTNode<Integer> temp = idTree.findFromKey(id);
        if (temp == null) {
            // not found
            output.println("Search FAILED -- There is no record with ID " + id);
        }
        else {
            // found
            output.println("Found record with ID " + id);
            output.println(temp.getRecord().getSem().toString());
        }
    }


    /**
     * method to search a range of costs
     * 
     * @param low
     *            low
     * @param high
     *            high
     * @param output
     *            output to print
     */
    public void searchCost(int low, int high, PrintWriter output) {
        output.println("Seminars with costs in range " + low + " to " + high);
        int nodes = costTree.range(costTree.getRoot(), low, high, output);
        output.println(nodes + " nodes visited in this search");
        
    }


    /**
     * method to search a range of dates
     * 
     * @param low
     *            low
     * @param high
     *            high
     * @param output
     *            output to print
     */
    public void searchDate(String low, String high, PrintWriter output) {
        output.println("Seminars with dates in range " + low + " to " + high);
        int nodes = dateTree.range(dateTree.getRoot(), low, high, output);
        output.println(nodes + " nodes visited in this search");

    }


    /**
     * method to search keywordBST for keyword
     * 
     * @param keyword
     *            keyword being searched
     * @return BSTNode that has the keyword & seminar or null
     */
    public BSTNode<String> searhKeyword(Record<String> keyword) {
        return keywordTree.find(keyword);
    }


    /**
     * method to print idBST
     * 
     * @param output
     *            PrintWriter object
     */
    public void printID(PrintWriter output) {
        idTree.printTree(output);
    }


    /**
     * method to print costBST
     * 
     * @param output
     *            PrintWriter obj
     */
    public void printCost(PrintWriter output) {
        costTree.printTree(output);
    }


    /**
     * method to print dateBST
     * 
     * @param output
     *            PrintWriter obj
     */
    public void printDate(PrintWriter output) {
        dateTree.printTree(output);
    }


    /**
     * method to print keyworkBST
     * 
     * @param output
     *            PrintWriter obj
     */
    public void printKeyword(PrintWriter output) {
        keywordTree.printTree(output);
    }

}
