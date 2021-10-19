/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Seoyoung Kong
 */

package baseline;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Solution45Test
{
    Solution45 test = new Solution45();
    private final Path path = Paths.get(System.getProperty("user.dir"));

    private Path getPathFromFileName(String fileName)
    {
        return Paths.get(path.toString(), "data", fileName);
    }

    @Test
    void search() throws IOException
    {
        String outFile;

        System.out.print("Output filename: ");
        outFile = "test";

        test.search("exercise45_input.txt", outFile);

        String[] expected = """
                One should never use the word "use" in writing. Use "use" instead.
                For example, "She uses an IDE to write her Java programs" instead of "She
                uses an IDE to write her Java programs".
                """.split("\n");

        assertTrue(Files.exists(getPathFromFileName(outFile)));

        int line = 0;

        try(Scanner info = new Scanner(new File(getPathFromFileName(outFile).toString())))
        {
            while(info.hasNext())
            {
                assertEquals(expected[line], info.nextLine());
                line ++;
            }
        }
    }
}
