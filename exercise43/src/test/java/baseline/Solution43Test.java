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

class Solution43Test
{
    private final Path currentPath = Paths.get(System.getProperty("user.dir"), "data");

    @Test
    void generate() throws IOException
    {
        Path testSiteRoot = Paths.get(currentPath.toString(),  "website", "siteName");

        website test = new website("siteName", "authorName", true, true);

        test.generate();

        assertTrue(Files.exists(testSiteRoot));

        assertTrue(Files.exists(Paths.get(testSiteRoot.toString(), "js")));
        assertTrue(Files.exists(Paths.get(testSiteRoot.toString(), "css")));

        assertTrue(Files.exists(Paths.get(testSiteRoot.toString(), "index.html")));

        final Scanner in = new Scanner(new File(Paths.get(currentPath.toString(), "index.html").toString()));

        String[] expected = """
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset="utf-8">
                <meta name = "author" content = "authorName">
                <title>siteName</title>
                </head>
                </html>
                """.split("\n");

        for(String line : expected)
        {
            assertEquals(line, in.nextLine());
        }
    }
}
