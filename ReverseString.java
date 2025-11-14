import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Program that reverses all the lines in an input file.
* And writes the reversed lines to an output file.
* The lines are reversed through a function that uses recursion.
*
* @author  Atri Sarker
* @version 1.0
* @since   2025-11-13
*/
public final class ReverseString {
  /**
   * Private constructor to satisfy style checker.
   * @exception IllegalStateException for the utility class.
   * @see IllegalStateException
   */
  private ReverseString() {
    // Prevents illegal states.
    throw new IllegalStateException("Utility class.");
  }

  /**
   * Recursive function that reverses a string.
   * @param str The string to be reversed.
   * @return The reversed string.
   */
  public static String reverseString(final String str) {
    // [Check if length is <= 1] [Base Case]
    if (str.length() <= 1) {
      // Return the string, as it is.
      // End of recursion chain.
      return str;
    } else {
      // Recursion call
      return reverseString(str.substring(1)) + str.charAt(0);
    }
  }

  /**
   * Entrypoint of the program.
   * @param args For command line arguments.
   */
  public static void main(final String[] args) {
    // First argument is the path to the input file.
    final String inputFilePath = args[0];
    // Second argument is the path to the output file.
    final String outputFilePath = args[1];
    // Print arguments
    System.out.println("Input file: " + inputFilePath);
    System.out.println("Output file: " + outputFilePath);
    // Read the input file
    try {
      // Access the input file and create a File object.
      File inputFile = new File(inputFilePath);
      // Access the output file and create a File object.
      File outputFile = new File(outputFilePath);
      // Scanner that will read the File Object.
      Scanner scanner = new Scanner(inputFile);
      // List to store all the lines in the input file
      ArrayList<String> listOfLines = new ArrayList<>();
      // Loop through all available lines
      while (scanner.hasNextLine()) {
        // Get the line
        String line = scanner.nextLine();
        // Add the line to the list
        listOfLines.add(line);
      }
      // Close the scanner [file reader]
      scanner.close();

      // Convert list to arrays
      // Passing new String[0] to toArray()
      // because toArray() automatically makes a bigger one.
      String[] arrOfLines = listOfLines.toArray(new String[0]);

      // String to hold all output
      String output = "";
      // Reverse every string and add it to the output string
      for (String line : arrOfLines) {
        // Reverse the line
        final String reversedString = reverseString(line);
        // Add it to the output
        output += reversedString;
        // Print transformation
        System.out.print(line);
        System.out.print(" -> ");
        System.out.println(reversedString);
        // Add a newline
        output += "\n";
      }
      // Write output to output file
      try {
        // Create a FileWriter object to write to the file
        FileWriter writer = new FileWriter(outputFile);
        // Write the output to the file
        writer.write(output);
        // Close the writer
        writer.close();
      } catch (IOException error) {
        System.out.println(error);
      }
    } catch (IOException error) {
      System.out.println(error);
    }
    // Completion message
    System.out.println("DONE!");
  }
}
