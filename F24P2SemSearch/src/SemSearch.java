import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The class containing the main method.
 *
 * @author Jett Morrow jettmorrow & Adam Schantz adams03
 * @version 9/24/2024
 */

// On my honor:
// - I have not used source code obtained from another current or
//   former student, or any other unauthorized source, either
//   modified or unmodified.
//
// - All source code and documentation used in my program is
//   either my original work, or was derived by me from the
//   source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
//   anyone other than my partner (in the case of a joint
//   submission), instructor, ACM/UPE tutors or the TAs assigned
//   to this course. I understand that I may discuss the concepts
//   of this program with other students, and that another student
//   may help me debug my program so long as neither of us writes
//   anything during the discussion or modifies any computer file
//   during the discussion. I have violated neither the spirit nor
//   letter of this restriction.


public class SemSearch {
    /**
     * @param args
     *     Command line parameters
     */
    public static void main(String[] args) {
        
        // input should be {worldsize} {input file} 
        if (args.length != 2) {
            throw new IllegalArgumentException(
                "Expected exactly 2 argument: {worldSize} {Command File}");
        }
        
        //world size has to be power of two
        // check if worldSize is int and power of 2
        int worldSize;
        try {
            worldSize = Integer.parseInt(args[0]);

            if (isPowerOfTwo(worldSize)) {
                throw new IllegalArgumentException(
                    "{HashTableSize} must be >= 1 & power of 2");
            }
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException(
                "{HashTableSize} must be a number");
        }
        
        // set up input Stream
        try (Scanner fileInput = new Scanner(new File(args[1]))) {
            // set up the output stream
            PrintWriter stdout = new PrintWriter(System.out);

            // create the Controller & interpreter
            Controller controller = new Controller(worldSize);
            CommandProcessor interpreter = new CommandProcessor(controller);

            // process all the commands in the input file
            interpreter.interpretAllLines(fileInput, stdout);
            fileInput.close();
            stdout.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * method to determine if an int is a power of 2
     * @param n number
     * @return true if power of two false if not
     */
    public static boolean isPowerOfTwo(int n) {
        if ( n <= 0) {
            return false;
        }
        else {
            while (n % 2 == 0) {
                n = n / 2;
            }
        }
        return n == 1;
    }
    
    //this is the main class
    //this creates a command processor to read from the command file
    //the CP has a controller class which holds the 5 trees
    //I need BST and BSTNode Class
    //I need record class
    
    //BSTNode needs to be generic for different types of trees
    //Record needs to be generic because it is data in BSTNode
}
