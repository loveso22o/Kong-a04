/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Seoyoung Kong
 */

package baseline;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class Solution45
{
    private static final Scanner in = new Scanner(System.in);

    private final Path path = Paths.get(System.getProperty("user.dir"));

    public void search(String inFile, String outFile) throws IOException
    {
        // Read inFile
        try(Scanner info = new Scanner(getPath(inFile)))
        {
            // Call other function to replace utilize with use
            replace(info, outFile);
        }
        catch (IOException ioException)
        {
            System.out.println("Unable to open input file at " + getPath(inFile));
        }
    }

    private void replace(Scanner in, String outFile) throws FileNotFoundException
    {
        String line;
        String change = "utilize";
        String replacement = "use";

        // Create outFile
        try(Formatter output = new Formatter(getPath(outFile).toString()))
        {
            while(in.hasNext())
            {
                // Read file line by line
                line = in.nextLine();

                // Replace "utilize" with "use"
                line = line.replace(change, replacement);

                // Print to outFile
                output.format("%s%n", line);

            }
        }
        catch (IOException ioException)
        {
            System.out.println("Unable to open output file at " + getPath(outFile));
        }

    }

    private Path getPath(String name)
    {
        // Return directory
        return Paths.get(path.toString(), "data", name);
    }

    public static void main(String[] args) throws IOException
    {
        Solution45 main = new Solution45();

        String outFile;

        // Ask user for outFile name
        System.out.println("Output filename: ");
        outFile = in.nextLine();


        // Replace the words with the functions
        main.search("exercise45_input.txt", outFile);
    }

}
