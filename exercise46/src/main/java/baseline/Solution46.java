/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Seoyoung Kong
 */

package baseline;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Solution46
{
    public Map<String, Integer> search() throws IOException
    {
        Map<String, Integer> map = new HashMap<>();

        // Open infile
        try(Scanner inFile = new Scanner(Paths.get("data/exercise46_input.txt")))
        {
            while(inFile.hasNext())
            {
                // Read each word from file
                String word = inFile.next();

                // Compare to keys on map
                if(map.containsKey(word))
                {
                    // If they are same set value to +1
                    map.put(word, map.get(word)+1);
                }
                else
                {
                    // If not same add new key with value of 1
                    map.put(word, 1);
                }


            }
        }catch (IOException ioException)
        {
            ioException.printStackTrace();
        }

        // Return map
        return map;
    }

    public Map<String, Integer> sort(Map<String, Integer> map)
    {
        // Create new map with new values gathered from search function
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public String createHistogram(Map<String, Integer> sortedMap)
    {
        // Use stringbuilder
        StringBuilder output = new StringBuilder();

        Set<String> keys = sortedMap.keySet();
        String[] keyArray = keys.toArray(new String[0]);

        // Use a for loop to create histogram
        for(int i=0; i<sortedMap.size(); i++)
        {
            output.append(keyArray[i]).append(":").append(" ".repeat(10 - keyArray[i].length()));
            output.append(" " + "*".repeat(sortedMap.get(keyArray[i])) + "%n");
        }

        // Return string
        return output.toString();
    }

    public static void main(String[] args) throws IOException {
        Solution46 main = new Solution46();

        // Create a map
        Map<String, Integer> map = main.search();

        // Sort the map using function
        Map<String, Integer> sortedMap = main.sort(map);

        // Assemble using function
        String output = main.createHistogram(sortedMap);

        // Print output
        System.out.printf(output);
    }
}
