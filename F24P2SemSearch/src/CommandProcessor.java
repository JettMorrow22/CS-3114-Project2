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

    /**
     * General constructor for CP
     * 
     * @param c
     *            the controller
     */
    public CommandProcessor(Controller c) {
        controller = c;
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
        String command = oneLine.next();

        output.flush();
    }

}
