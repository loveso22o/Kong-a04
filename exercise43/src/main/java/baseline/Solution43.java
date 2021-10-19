/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Seoyoung Kong
 */

package baseline;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class Solution43
{
    private static final Scanner in = new Scanner(System.in);

    private boolean input(String prompt)
    {
        String answer;
        while(true)
        {
            System.out.println(prompt);

            answer = in.nextLine().toUpperCase(Locale.ROOT);

            if(answer.equals("Y"))
            {
                return true;
            }
            else if(answer.equals("N"))
            {
                return false;
            }
            else
            {
                System.out.println("Enter Y for yes or N for no");
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Solution43 main = new Solution43();

        String websiteName;
        String authorName;
        boolean jsFolder;
        boolean cssFolder;

        System.out.println("Site name: ");
        websiteName = in.nextLine();

        System.out.println("Author: ");
        authorName = in.nextLine();

        jsFolder = main.input("Do you want a folder for JavaScript? ");

        cssFolder = main.input("Do you want a folder for CSS? ");

        website create = new website(websiteName, authorName, jsFolder, cssFolder);

        create.generate();

        System.exit(0);
    }

}

class website
{
    private final Path currentPath = Paths.get(System.getProperty("user.dir"), "data");

    private  Path siteRoot;

    private final String websiteName;
    private final String authorName;

    private final boolean jsFolder;
    private final boolean cssFolder;

    public website(String name, String author, boolean jsFolder, boolean cssFolder)
    {
        // Assign values from solution43 Class to this one
        this.websiteName = name;
        this.authorName = author;

        this.jsFolder = jsFolder;
        this.cssFolder = cssFolder;
    }

    public void generate() throws IOException
    {
        // Create root folder
        siteRoot = Paths.get(currentPath.toString(), "website", websiteName);

        boolean success = new File(siteRoot.toString()).mkdirs();

        if(success)
        {
            System.out.println("Created " + siteRoot.toString().replaceFirst(currentPath.toString().replace("\\", "\\\\"), "."));
        }
        else
        {
            System.out.println("Unable to create directory in " + siteRoot.toString());
        }

        // Create index (FUNCTION?)
        generateIndex();


        // Make folder for js or css depending on what user chooses
        if(jsFolder)
        {
            generateDirectory("js");
        }
        if(cssFolder)
        {
            generateDirectory("css");
        }
    }

    private void generateIndex() throws IOException
    {
        // Create the header, heading, author, title etc...
        String indexHeader = "index.html";

        try(Formatter output = new Formatter(Paths.get(siteRoot.toString(), indexHeader).toString()))
        {
            output.format("<!DOCTYPE html>%n");

            output.format("<html>%n");

            output.format("<head>%n");

            output.format("<meta charset=\"utf-8\">%n");

            String authorMeta = String.format("<meta name = \"author\" content = \"%s\">%n", authorName);
            output.format(authorMeta);

            String title = String.format("<title>%s</title>%n", websiteName);
            output.format(title);

            output.format("</head>%n");

            output.format("</html>%n");
        }

        System.out.println("Created " + Paths.get(siteRoot.toString(), indexHeader).toString().replaceFirst(
                currentPath.toString().replace("\\", "\\\\"), "."));
    }

    private void generateDirectory(String directoryName)
    {
        // Create path to new directory
        Path newPath = Paths.get(siteRoot.toString(), directoryName);

        boolean success = new File(newPath.toString()).mkdirs();

        // Display path to new directory
        if(success)
        {
            System.out.println("Created " + newPath.toString().replaceFirst(currentPath.toString().replace("\\", "\\\\"), "."));
        }
        else
        {
            System.out.println("Unable to create directory at " + newPath);
        }
    }
}
