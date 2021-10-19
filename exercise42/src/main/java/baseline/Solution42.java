/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Seoyoung Kong
 */
package baseline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution42
{
    public List<String> readInput(String input) throws IOException
    {
        String temp;

        FileReader reader = new FileReader(input);

        BufferedReader readerTwo = new BufferedReader(reader);

        List<String> info = new ArrayList<>();

        while((temp = readerTwo.readLine()) != null)
        {
            String [] lines = temp.split(",");

            String firstName = lines[0];
            String lastName = lines[1];
            String salary = lines[2];

            info.add(firstName);
            info.add(lastName);
            info.add(salary);
        }

        reader.close();
        return info;
    }

    private void output(List<String> info, String outFile) throws IOException
    {
        int i = 0;

        FileWriter writer = new FileWriter(outFile);

        PrintWriter print = new PrintWriter(writer);

        print.println("Last      First     Salary");
        print.println("--------------------------");

        for(String out : info)
        {
            print.printf("%-10s", out);

            i++;

            if(i%3 == 0)
            {
                print.println();
            }
        }
        writer.close();

        print.flush();
        print.close();
    }

    public static void main(String[] args) throws IOException {
        Solution42 main = new Solution42();

        List<String> info = main.readInput("data/exercise42_input.txt");

        main.output(info, "data/exercise42_output.txt");

        BufferedReader br = new BufferedReader(new FileReader("data/exercise42_output.txt"));

        String line;

        while ((line = br.readLine()) != null)
        {
            System.out.println(line);
        }
    }
}