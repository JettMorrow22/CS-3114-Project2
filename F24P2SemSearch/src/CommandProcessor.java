import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Command Processor Class
 *
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 9/24/2024
 */
public class CommandProcessor {

    // commands are insert, remove, print
    private Controller controller;
    private int worldSize;

    /**
     * General constructor for CP
     * 
     * @param c
     *            the controller
     */
    public CommandProcessor(Controller c, int w) {
        controller = c;
        worldSize = w;
    }


    /**
     * method to interprete one line at a time
     * 
     * @param input
     *            the scanner
     * @param output
     *            the output
     */
    public void interpretAllLines(Scanner input, PrintWriter output) {
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            // Skip over any blank input lines
            if (!line.isEmpty()) {
                this.interpretLine(new Scanner(line), output, input);
            }
        }
        output.close();
    }


    /**
     * Where each line is procesessed
     * the first word determines the main command which determines what the next
     * possible words could be and mean, all input is send to controller with
     * approiorate methods
     * 
     * @param oneLine
     *            scanner object
     * @param output
     *            our output function
     * @param remainingInputLines
     *            the remainder of the input file
     */
    public void interpretLine(
        Scanner oneLine,
        PrintWriter output,
        Scanner remainingInputLines) {

        // we first have to process the first word (insert, remove, print)
        // depending on first word they have dif following input
        // insert, delete, search, print
        String command = oneLine.next().trim();
        switch (command) {
            case "insert":
                int id = oneLine.nextInt();
                oneLine.nextLine(); // this is to get to the next line
                String title = oneLine.next().trim();
                oneLine.nextLine();
                String dateTime = oneLine.next().trim();
                int length = oneLine.nextInt();
                int x = oneLine.nextInt();
                int y = oneLine.nextInt();
                int cost = oneLine.nextInt();
                oneLine.nextLine(); // go to next line
                String keywordsLine = oneLine.nextLine();
                String[] keywords = keywordsLine.split(" ");
                String description = oneLine.nextLine();

                if (x >= 0 && x < worldSize && y >= 0 && y < worldSize) {

                    Seminar temp = new Seminar(id, title, dateTime, length,
                        (short)x, (short)y, cost, keywords, description);

                    if (controller.searchID(new Record<Integer>(id,
                        temp)) == null) {
                        // valid seminar add it to all 4 trees and thigns
                        controller.insertAllTrees(temp, output);
                    }
                    else {
                        // seminar already exists
                        output.println(
                            "Insert FAILED - There is already a record with ID "
                                + id);
                    }
                }
                else {
                    // bad x and y
                    output.println("Insert FAILED - Bad x, y coordinates: " + x
                        + ", " + y);
                }

                break;
            case "delete":

                break;
            case "search":
                // search is weird because it is ranges
                String tree = oneLine.next().trim();
                switch (tree) {
                    case "ID":
                        int idVal = oneLine.nextInt();
                        controller.searchID(new Record<Integer>(idVal, null));

                        break;
                    case "keyword":
                        String keyword = oneLine.next().trim();

                        break;

                }

                int low = oneLine.nextInt();
                int high = oneLine.nextInt();
                switch (tree) {
                    case "cost":

                        break;
                    case "date":

                        break;
                }

// if (tree.equals("location")) {
// int r = oneLine.nextInt();
// }

                break;
            case "print":

                break;
        }
        output.flush();
    }

}
