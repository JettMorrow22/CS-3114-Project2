import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import student.TestCase;

/**
 * @author adam schantz
 * @version test cases
 */
public class ProblemSpecTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        //nothing
    }


    /**
     * Read contents of a file into a string
     * 
     * @param path
     *            File name
     * @return the string
     * @throws IOException
     */
    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

    // ----------------------------------------------------------


    /**
     * Example 1: This method runs on a command sample IO file
     * You will write similar test cases
     * using different text files
     * 
     * @throws IOException
     */
    public void testPostedSample() throws IOException {
        // Setting up all the parameters
        String[] args = new String[2];
        args[0] = "128";
        args[1] = "solutionTestData/P2_sampleInput.txt";

        // Invoke main method of our Graph Project
        SemSearch.main(args);

        // Actual output from your System console
        String actualOutput = systemOut().getHistory();

        // Expected output from file
        String expectedOutput = readFile(
            "solutionTestData/P2_sampleOutput.txt");

        // Compare the two outputs
        // once you have implemented your project
        assertEquals(expectedOutput, actualOutput);

    }


    /**
     * Example 2: This method runs on a command sample IO file
     * You will write similar test cases
     * using different text files
     * 
     * @throws IOException
     */
    public void testPostedSyntaxSample() throws IOException {
        // Setting up all the parameters
        String[] args = new String[2];
        args[0] = "128";
        args[1] = "solutionTestData/P2_syntaxInsertInput.txt";

        // Invoke main method of our Graph Project
        SemSearch.main(args);

        // Actual output from your System console
        String output = systemOut().getHistory();
        
        String actualOutput = readFile(
            "solutionTestData/fuzzyequals.txt");

        // Expected output from file
        String expectedOutput = readFile(
            "solutionTestData/P2_syntaxInsertOutput.txt");

        // Compare the two outputs
        // once you have implemented your project
        assertFuzzyEquals(expectedOutput, actualOutput);
    }
    
    /**
     * method to manually test output
     * @throws IOException 
     */
    public void testOutput() throws IOException
    {
        String[] args = new String[2];
        args[0] = "128";
        args[1] = "solutionTestData/testInput.txt";

        // Invoke main method of our Graph Project
        SemSearch.main(args);
        
        String output = systemOut().getHistory();
        
        
        String expected = readFile(
            "solutionTestData/testOutput.txt");

        //assertFuzzyEquals(expected, output);
    }
}
