/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Seoyoung Kong
 */
package baseline;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Solution41
{
    public List<String> readNames(String input) throws IOException
    {
        List<String> names = new ArrayList<>();
        try(Scanner inFile = new Scanner(Paths.get(input)))
        {
            while (inFile.hasNext()) {
                names.add(inFile.next() + " " + inFile.next() + "\r");
            }
        }
        return names;
    }

    private void sort(List<String> names)
    {
        try {
            for (int i = 0; i < names.size(); i++) {
                for (int j = 0; j < names.size()-i-1; j++) {
                    if (names.get(j).compareTo(names.get(j + 1)) > 0) {
                        Collections.swap(names, j, j + 1);
                    }
                }

            }
        } catch(IndexOutOfBoundsException indexOutOfBoundsException)
        {
            System.out.println("Error try again.");
        }
    }

    private String output(List<String> names)
    {
        StringBuilder sortedNames = new StringBuilder();
        sort(names);
        sortedNames.append("Total of ").append(names.size()).append(" names\r-----------------\r");

        for(String temp : names)
        {
            sortedNames.append(temp);
        }
        return sortedNames.toString();
    }

    private void sendOutputToFile(String output) throws IOException
    {
        try (Formatter outFile = new Formatter("data/exercise41_output.txt")) {
            outFile.format(output);
        }
    }

    public static void main(String[] args) throws IOException
    {
        Solution41 main = new Solution41();

        List<String>names = main.readNames("data/exercise41_input.txt");
        String out = main.output(names);
        main.sendOutputToFile(out);
    }
}
